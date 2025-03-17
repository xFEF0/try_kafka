package com.xfef0.try_kafka.kafka.consumer;

import com.xfef0.try_kafka.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaJsonConsumer {

    @KafkaListener(topics = "#{'${spring.kafka.topic.user}'}", groupId = "group_id")
    public void consume(User user) {
        log.info("Received user: {}", user);
    }
}
