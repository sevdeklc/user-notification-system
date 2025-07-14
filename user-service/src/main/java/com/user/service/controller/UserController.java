package com.user.service.controller;

import com.user.service.domain.dto.UserCreatedEvent;
import com.user.service.service.UserService;
import com.user.service.util.api.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<String> addUser(@RequestBody UserCreatedEvent userCreatedEvent) {
        return userService.createUser(userCreatedEvent);
    }

}
