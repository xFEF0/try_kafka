package com.xfef0.try_kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("$spring.kafka.topic.message")
    private String messageTopic;
    @Value("$spring.kafka.topic.user")
    private String userTopic;

    @Bean
    public NewTopic messageTopic() {
        return TopicBuilder.name(messageTopic)
                .build();
    }

    @Bean
    public NewTopic userTopic() {
        return TopicBuilder.name(userTopic)
                .build();
    }
}
