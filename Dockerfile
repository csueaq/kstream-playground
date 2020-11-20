FROM gradle:6.1.1-jdk11 AS builder

WORKDIR /var/app

COPY . .

RUN gradle clean shadowJar

FROM gcr.io/distroless/java:11

COPY --from=builder /var/app/build/libs/*.jar /app.jar

CMD ["/app.jar"]
