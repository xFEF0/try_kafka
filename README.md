# Try Kafka
Learning Kafka through a Spring Boot app

## Run

In a terminal, at the project directory level, start zookeeper and kafka broker containers with the command:

`docker compose up -d`

Run the app.
 ### Two more apps
kafka-producer-wiki module streams the information collected from wikimedia lastchange endpoint and sends it to a kafka topic.
kafka-consumer-wiki module consumes the messages from the same topic, and saves it to a postgreSQL DB.


