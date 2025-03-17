package com.xfef0.try_kafka.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "#{'${spring.kafka.topic-name}'}", groupId = "group_id")
    public void consume(String message) {
        log.info("Received: {}", message);
    }
}
