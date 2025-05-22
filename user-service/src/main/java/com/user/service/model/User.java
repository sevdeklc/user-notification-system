package com.user.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
}
