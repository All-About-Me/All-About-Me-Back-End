package com.revature.services;

import com.revature.models.User;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Optional;

@Service
public class AuthService {

    private final UserService userService;

    public AuthService(UserService userService) {
        this.userService = userService;
    }

    public Optional<User> findByCredentials(String email, String password) {
        return userService.findByCredentials(email, password);
    }

    public User register(User user) {
        return userService.save(user);
    }
    
    public Optional<User> findByfirstName(String firstName) {
        return userService.findByfirstName(firstName);
    }
    
    public Optional<User> findBylastName(String lastName) {
        return userService.findBylastName(lastName);
    }
}
