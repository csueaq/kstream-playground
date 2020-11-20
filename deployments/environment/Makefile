.PHONY: setup kafka kafka-cli toolbox

KUBECTL?=kubectl
HELM?=helm
POSTGRES_VERSION?=11
KSQL_SERVER_HOST?=:18088

setup:
	$(HELM) repo add stable https://charts.helm.sh/stable
	$(HELM) repo add incubator https://charts.helm.sh/incubator
	$(HELM) repo update

kafka: setup
	$(HELM) upgrade -i kafka -f kafka.yaml incubator/kafka

kafka-cli:
	$(KUBECTL) run --generator=run-pod/v1 -i --tty kafka-cli --image=confluentinc/cp-kafka:5.0.1 -- sh

toolbox:
	$(KUBECTL) run --generator=run-pod/v1 -i --tty toolbox --image=gcr.io/google-containers/toolbox -- sh
