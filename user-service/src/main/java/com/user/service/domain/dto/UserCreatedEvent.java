package com.user.service.domain.dto;

import com.user.service.domain.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreatedEvent {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
}
