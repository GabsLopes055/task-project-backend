package com.task.list.service;

import com.task.list.entity.UserEntity;
import com.task.list.repository.UserRepository;
import com.task.list.DTOs.request.loginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public boolean login(loginRequest request){

        Optional<UserEntity> findUser = Optional.ofNullable(repository.findByEmail(request.getEmail()));

        if (findUser.isEmpty()) {
            return false;
        }
        return encoder.matches(request.getPassword(),findUser.get().getPassword());

    }

}
