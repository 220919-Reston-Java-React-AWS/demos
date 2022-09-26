package com.revature.service;

import com.revature.model.User;
import com.revature.repository.UserRepository;

import java.util.List;

public class UserService {

    private UserRepository userRepository = new UserRepository();

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

}
