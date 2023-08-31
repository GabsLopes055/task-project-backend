package com.task.list.service;

import com.task.list.DTOs.request.UserRequest;
import com.task.list.DTOs.response.UserResponse;
import com.task.list.entity.UserEntity;
import com.task.list.repository.UserRepository;
import com.task.list.validators.PassCrypt;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public UserResponse saveNewUser(@Valid UserRequest user) {

        UserEntity newUser = new UserEntity();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(encoder.encode(user.getPassword()));

//        repository.save(newUser);

        return UserResponse.UserResponseDTO(repository.save(newUser));

    }

}
