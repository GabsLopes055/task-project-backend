package com.task.list.controller;

import com.task.list.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import com.task.list.DTOs.request.loginRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "task-api/login")
@RestController
public class LoginController {

    @Autowired
    private LoginService service;


    @PostMapping
    @CrossOrigin(value = "*")
    public ResponseEntity<Boolean> login(@RequestBody loginRequest request) {
        if(service.login(request)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.login(request));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(service.login(request));
    }

}
