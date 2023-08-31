package com.task.list.DTOs.request;

public class userRequest {

    private Long cdUser;

    private String name;

    private String email;

    private String password;

    public Long getCdUser() {
        return cdUser;
    }

    public void setCdUser(Long cdUser) {
        this.cdUser = cdUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
