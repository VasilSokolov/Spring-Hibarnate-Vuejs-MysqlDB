package com.spring.demo.controller;

//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value="/home")
public class HomeController {

//    @GetMapping(value="/")
//    public String index(){
//        return "index";
//    }

    @GetMapping(value="/registration")
    public String register(){
        return "register";
    }

    @GetMapping(value="/login")
    public String login(){
        return "login";
    }

//    @GetMapping(value="users/{id}")
//    public String singlePost(){
//        return "users";
//    }
}
