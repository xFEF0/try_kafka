package com.xfef0.try_kafka.kafka.producer;

import com.xfef0.try_kafka.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping("/publish/message")
    public ResponseEntity<Boolean> publishMessage(@RequestBody String message) {
        try {
            kafkaProducer.sendMessage(message);
            return ResponseEntity.ok(Boolean.TRUE);
        } catch (Exception e) {
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/publish/user")
    public ResponseEntity<Boolean> publishUser(@RequestBody User user) {
        try {
            kafkaJsonProducer.sendMessage(user);
            return ResponseEntity.ok(Boolean.TRUE);
        } catch (Exception e) {
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
