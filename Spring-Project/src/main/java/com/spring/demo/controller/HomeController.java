package com.spring.demo.controller;

import com.spring.demo.model.LoginModel;
import com.spring.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/home")
public class HomeController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public String home() {
        return "home";
    }


//    @PostMapping("/register")
//    public List<User> getRegisterPage(@Valid @RequestBody RegisterModel registerModel) {
//        return userService.save();
//    }

    @PostMapping("/login")
    public void register(@Valid @RequestBody LoginModel loginModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            System.out.println();
        }
        userService.login(loginModel);
    }
}
