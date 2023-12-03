package com.task.list.controller;

import com.task.list.DTOs.request.userRequest;
import com.task.list.DTOs.response.UserResponse;
import com.task.list.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "task-api/user")
@CrossOrigin(value = "*")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping
    public ResponseEntity<UserResponse> saveNewUser(@RequestBody userRequest user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveNewUser(user));
    }

}
