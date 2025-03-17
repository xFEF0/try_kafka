package com.xfef0.try_kafka.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
@Service
@Slf4j
public class KafkaProducer {

    @Value("${spring.kafka.topic.message}")
    private String messageTopic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(messageTopic, message);
        future.whenComplete((sendResult, exception) -> {
           if (exception != null) {
               future.completeExceptionally(exception);
           } else {
               future.complete(sendResult);
           }

           log.info("Message sent {} to topic {}", message, messageTopic);
        });
    }
}
