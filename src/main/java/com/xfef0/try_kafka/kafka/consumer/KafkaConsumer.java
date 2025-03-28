package com.xfef0.try_kafka.kafka.consumer;

import com.xfef0.try_kafka.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "#{'${spring.kafka.topic.message}'}", groupId = "group_id")
    public void consume(String message) {
        log.info("Received message: {}", message);
    }
}
