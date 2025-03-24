package com.xfef0.springboot;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    public static final String WIKIMEDIA_TOPIC = "wikimedia_recent_change";

    @Bean
    public NewTopic messageTopic() {
        return TopicBuilder.name(WIKIMEDIA_TOPIC)
                .build();
    }


}
