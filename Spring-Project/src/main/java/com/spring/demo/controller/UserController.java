package com.spring.demo.controller;

import com.spring.demo.entity.User;
import com.spring.demo.service.UserServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserServiceImpl userService;   

    @Autowired
    public UserController(UserServiceImpl userService) {
		this.userService = userService;
	}

	@GetMapping
    public List<User> getUsers() {
        List<User> users = userService.findAll();
        System.out.println(users.toString());
        return users;
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable Long id) {
        return userService.findOne(id);
    }

//    @DeleteMapping("/user/{id}")
//    public boolean deleteUser(@PathVariable Long id) {
//        userService.delete(id);
//        return true;
//    }
    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") User user) {
        userService.delete(user);
    }

//    @PutMapping("/user")
//    public User updateUser(@RequestBody User user) {
//        return userRepository.save(user);
//    }

    @PostMapping
    public User createUser(@RequestBody User user) {

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
}
