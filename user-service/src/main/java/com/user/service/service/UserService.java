package com.user.service.service;

import com.user.service.domain.dto.UserCreatedEvent;
import com.user.service.kafka.KafkaProducer;
import com.user.service.util.api.ApiResponse;
import com.user.service.util.api.ApiResult;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final KafkaProducer kafkaProducer;

    public UserService(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    public ApiResponse<String> createUser(UserCreatedEvent event) {
        try {
            kafkaProducer.sendUserCreatedEvent(event);
            return new ApiResponse<>("OK");
        } catch (Exception e) {
            ApiResult errorResult = new ApiResult(1, "Failed to send Kafka message: " + e.getMessage());
            ApiResponse<String> response = new ApiResponse<>();
            response.setResult(errorResult);
            return response;
        }
    }

}
