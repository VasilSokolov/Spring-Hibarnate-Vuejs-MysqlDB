package com.spring.demo.model;

import javax.validation.constraints.Size;

public class UserRegistration {

    private Long id;
    private String username;
    private String password;
    private String confirmPassword;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Size(min = 5, message = "Username is too short")
    public String getUsername() {
        return username;
    }

    public void setUsername(String loginUser) {
        this.username = loginUser;
    }

    @Size(min = 8, message = "Password is too short")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
