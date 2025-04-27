package com.user.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "user-created-topic";

    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC, message);
    }

}
