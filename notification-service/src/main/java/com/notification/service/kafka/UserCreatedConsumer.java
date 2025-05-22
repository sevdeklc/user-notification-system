package com.notification.service.kafka;

import com.notification.service.model.User;
import com.notification.service.repository.UserRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserCreatedConsumer {

    private final UserRepository userRepository;

    public UserCreatedConsumer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @KafkaListener(topics = "user-created-topic", groupId = "notification-group", containerFactory = "userKafkaListenerContainerFactory")
    public void consume(User user) {
        System.out.println("Received user: " + user);
        userRepository.save(user);
    }
}
