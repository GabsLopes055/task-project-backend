package com.task.list.DTOs.response;

import com.task.list.entity.UserEntity;

public class UserResponse {

    private String name;

    private String email;


    public static UserResponse UserResponseDTO(UserEntity save) {

        UserResponse response = new UserResponse();

        response.setEmail(save.getEmail());
        response.setName(save.getName());

        return response;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
