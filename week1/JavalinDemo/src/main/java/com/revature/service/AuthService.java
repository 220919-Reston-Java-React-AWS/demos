package com.revature.service;

import com.revature.model.User;
import com.revature.repository.UserRepository;

public class AuthService {

    private UserRepository userRepository = new UserRepository();

    // Business logic
    // Input validation
    // Ex. we want to check if the user is trying to use spaces in their username and password and NOT allow that to happen
    public void register(User user) {
        if (user.getUsername().contains(" ") || user.getPassword().contains(" ")) {
            throw new IllegalArgumentException("Spaces are not allowed in usernames or passwords");
        }

        userRepository.addUser(user); // Add user to the repository
    }

}
