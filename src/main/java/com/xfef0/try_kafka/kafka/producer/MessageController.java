package com.xfef0.try_kafka.kafka.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private final KafkaProducer kafkaProducer;

    @PostMapping("/publish")
    public ResponseEntity<Boolean> publish(@RequestBody String message) {
        try {
            kafkaProducer.sendMessage(message);
            return ResponseEntity.ok(Boolean.TRUE);
        } catch (Exception e) {
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
