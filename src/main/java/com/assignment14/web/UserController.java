package com.assignment14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment14.domain.User;
import com.assignment14.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping("/users")
    public User createUser (@RequestBody String name) {
        User user = userService.createUser(name);
        return user;
    }
}
