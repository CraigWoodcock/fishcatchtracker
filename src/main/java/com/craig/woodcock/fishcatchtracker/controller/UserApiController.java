package com.craig.woodcock.fishcatchtracker.controller;

import com.craig.woodcock.fishcatchtracker.model.entity.User;
import com.craig.woodcock.fishcatchtracker.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private final UserService userService;

    @Autowired
    public UserApiController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
public List<User> getUsers() {
        return userService.findAllUsers();
}
}
