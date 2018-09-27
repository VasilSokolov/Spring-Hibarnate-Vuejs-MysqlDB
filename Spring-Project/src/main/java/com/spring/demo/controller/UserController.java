package com.spring.demo.controller;

import com.spring.demo.entity.User;
import com.spring.demo.service.UserServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@CrossOrigin(origins="*", maxAge=3600, allowedHeaders={"x-auth-token", "x-requested-with", "x-xsrf-token"})
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserServiceImpl userService;

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
	@GetMapping
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable Long id) {
        return userService.findOne(id);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") User user) {
        userService.delete(user);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userService.save(user);
    }

    @PutMapping("{id}")
    public User updateUser(
            @PathVariable("id") User userFromDb,
            @RequestBody User user
    ) {
        BeanUtils.copyProperties(user, userFromDb, "id");

        return userService.save(userFromDb);
    }

//    @GetMapping(value ="/getUsername")
//    public String getUsername(){
//        return SecurityContextHolder.getContext().getAuthentication().getName();
//    }

}
