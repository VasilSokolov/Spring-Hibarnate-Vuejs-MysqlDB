package com.spring.demo.model;

import javax.validation.constraints.Size;

public class LoginModel {

    private String loginUser;
    private String password;
    private String confirmPassword;

    @Size(min = 5, message = "Username is too short")
    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
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
