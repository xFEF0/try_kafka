package com.xfef0.try_kafka.kafka.producer;

import com.xfef0.try_kafka.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;


@RequiredArgsConstructor
@Service
@Slf4j
public class KafkaJsonProducer {

    @Value("${spring.kafka.topic.user}")
    private String userTopic;

    private final KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User user) {
        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, userTopic)
                .build();

        CompletableFuture<SendResult<String, User>> future = kafkaTemplate.send(message);

        future.whenComplete((result, exception) -> {
            if (exception != null) {
                future.completeExceptionally(exception);
            } else {
                future.complete(result);
            }
            log.info("Message sent to topic {} with user: {}", userTopic, user);
        });
    }

}
