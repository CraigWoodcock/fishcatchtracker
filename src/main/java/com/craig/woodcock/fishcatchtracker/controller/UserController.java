package com.craig.woodcock.fishcatchtracker.controller;

import com.craig.woodcock.fishcatchtracker.model.entity.User;
import com.craig.woodcock.fishcatchtracker.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(User user, Model model) {
        if (userService.registerUser(user)) {
            return "redirect:/login";
        } else {
            model.addAttribute("error", "Registration failed, please try again.");
            return "register";
        }
    }
}
