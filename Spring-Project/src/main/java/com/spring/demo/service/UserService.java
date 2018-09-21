package com.spring.demo.service;

import com.spring.demo.entity.User;
import com.spring.demo.model.LoginModel;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findOne(Long id);
    User save(User user);
    void delete(User user);
    void login(LoginModel loginModel);
}
