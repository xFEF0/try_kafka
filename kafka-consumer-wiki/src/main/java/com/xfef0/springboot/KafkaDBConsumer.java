package com.xfef0.springboot;

import com.xfef0.springboot.entity.WikimediaData;
import com.xfef0.springboot.repository.WikimediaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class KafkaDBConsumer {

    private final WikimediaRepository repository;

    @KafkaListener(
            topics = "wikimedia_recent_change",
            groupId = "my_group"
    )
    public void consume(String eventMessage) {
        log.info("Event message received -> {}", eventMessage);
        WikimediaData data = new WikimediaData();
        data.setWikiEventData(eventMessage);
        repository.save(data);
    }
}
