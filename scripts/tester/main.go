package main

import (
	"math/rand"
	"strings"
	"time"

	"github.com/segmentio/kafka-go"
	log "github.com/sirupsen/logrus"
	"github.com/spf13/viper"

	stream "github.com/sbs-discovery-sweden/labs-stream-library"
)

type Event struct {
	ID    string `json:"id"`
	Value int    `json:"value"`
}

func main() {

	viper.BindEnv("kafka.url", "KAFKA_CNX_STRING")
	viper.BindEnv("kafka.producer.topic", "KAFKA_PRODUCING_TOPIC")

	writers := stream.InitKafkaProducers(
		[]stream.Config{
			stream.Config{
				Topic:       viper.GetString("kafka.producer.topic"),
				URL:         strings.Split(viper.GetString("kafka.url"), ","),
				TLS:         stream.GetTLS(stream.TLSConfig{UseTLS: false}),
				GroupID:     "kstream-test-app.cgroup",
				Async:       true,
				Logger:      kafka.LoggerFunc(log.Debugf),
				ErrorLogger: kafka.LoggerFunc(log.Errorf),
			},
		},
	)

	EventLoadTest(writers)
}

// EventLoadTest produces 10000 random events on the <dummy> topic
func EventLoadTest(writers []*kafka.Writer) {
	producer := stream.NewKafkaStream(writers)

	log.Infof("Env vars %s", viper.AllSettings())
	rand.Seed(time.Now().UnixNano())

	event := Event{}

	for i := 0; i < 100000; i++ {
		switch i % 5 {
		case 0:
			event.ID = "a"
		case 1:
			event.ID = "b"
		case 2:
			event.ID = "c"
		case 3:
			event.ID = "d"
		case 4:
			event.ID = "e"
		}

		event.Value = rand.Intn(2)

		go producer.SendEvent(event, viper.GetString("kafka.producer.topic"))
	}

	producer.Close(viper.GetString("kafka.producer.topic"))
}
