package com.spring.demo.controller;

import com.spring.demo.entity.User;
import com.spring.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

@Controller(value="/")
public class HomeController {
	
	private final UserServiceImpl userServiceImpl;
	
	@Value("${spring.profiles.active}")
    private String profile;
	
	@Autowired
	public HomeController(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	@GetMapping()
    public String main( Model model) {
        HashMap<Object, Object> data = new HashMap<>();
        User user = new User("Ivan", "Ivanov", "ADMIN");
        Number number = 1;
        user.setId(number.longValue());
        user.setUsername("Ivan");
        data.put("profile", user);
        data.put("users", userServiceImpl.findAll());

        model.addAttribute("frontendData", data);
        model.addAttribute("isDevMode", "dev".equals(profile));

        return "index";
    }

    @GetMapping(value="/registration")
    public String register(){
        return "register";
    }

    @GetMapping(value="/login")
    public String login(){
        return "login";
    }

    @GetMapping(value="user/{id}")
    public String singleUser(){
        return "user";
    }
}
