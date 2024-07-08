package com.craig.woodcock.fishcatchtracker.model.service;

import com.craig.woodcock.fishcatchtracker.model.entity.User;
import com.craig.woodcock.fishcatchtracker.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    public List<User> findAllUsers(){

        return userRepository.findAll();
    };


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public boolean registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent() ||
                userRepository.findByEmail(user.getEmail()).isPresent()) {
            return false;
        }
        user.setPassword(user.getPassword());
        userRepository.save(user);
        return true;
    }
}
