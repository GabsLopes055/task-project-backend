package com.task.list.controller;

import com.task.list.DTOs.request.UserRequest;
import com.task.list.DTOs.response.UserResponse;
import com.task.list.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "task-api/user")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping
    public ResponseEntity<UserResponse> saveNewUser(@RequestBody UserRequest user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveNewUser(user));
    }

}
