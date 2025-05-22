package com.user.service.kafka;

import com.user.service.domain.dto.UserCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    private final KafkaTemplate<String, UserCreatedEvent> kafkaTemplate;
    private static final String TOPIC = "user-created-topic";

    public KafkaProducer(KafkaTemplate<String, UserCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendUserCreatedEvent(UserCreatedEvent event) {
        kafkaTemplate.send(TOPIC, event);
    }
}
