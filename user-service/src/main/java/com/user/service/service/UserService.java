package com.user.service.service;

import com.user.service.domain.dto.UserCreatedEvent;
import com.user.service.kafka.KafkaProducer;
import com.user.service.util.api.ApiResponse;
import com.user.service.util.api.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    private final KafkaProducer kafkaProducer;

    public UserService(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    public ApiResponse<String> createUser(UserCreatedEvent event) {
        try {
            kafkaProducer.sendUserCreatedEvent(event);
            log.info("User created ** sevde");
            return new ApiResponse<>("OK");
        } catch (Exception e) {
            ApiResult errorResult = new ApiResult(1, "Failed to send Kafka message: " + e.getMessage());
            ApiResponse<String> response = new ApiResponse<>();
            response.setResult(errorResult);
            return response;
        }
    }

}
