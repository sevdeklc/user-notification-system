package com.user.service.controller;

import com.user.service.domain.dto.UserCreatedEvent;
import com.user.service.kafka.KafkaProducer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RequestMapping("/user")
@RestController
public class UserController {

    private final KafkaProducer kafkaProducer;

    public UserController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addUser(@RequestBody UserCreatedEvent userCreatedEvent) {
        kafkaProducer.sendUserCreatedEvent(userCreatedEvent);
        return new ResponseEntity<>("User creation event sent to Kafka.", HttpStatus.OK);
    }

}
