package com.xfef0.springboot;

import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.WebSocketListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Service
@Slf4j
public class WikimediaChangesProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage() throws InterruptedException {
        String wikimediaTopic = KafkaTopicConfig.WIKIMEDIA_TOPIC;
        String url = "https://stream.wikimedia.org/v2/stream/recentchange/";
        BackgroundEventHandler handler = new WikimediaChangesHandler(kafkaTemplate, wikimediaTopic);
        EventSource.Builder eventSource = new EventSource.Builder(URI.create(url));
        BackgroundEventSource backgroundEventSource = new BackgroundEventSource
                .Builder(handler, eventSource)
                .build();
        backgroundEventSource.start();
        TimeUnit.MINUTES.sleep(10);

    }
}
