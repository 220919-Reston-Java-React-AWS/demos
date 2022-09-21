package com.revature.service;

import com.revature.exception.NotOldEnoughException;
import com.revature.exception.UsernameAlreadyTakenException;
import com.revature.model.User;
import com.revature.repository.AuthRepository;

public class AuthService {

    public AuthRepository authRepository = new AuthRepository();

    public void register(String username, String password, String age) throws NotOldEnoughException, UsernameAlreadyTakenException {
        int convertedAge = Integer.parseInt(age); // Convert a String into an int

        if (convertedAge < 18) {
            throw new NotOldEnoughException("You must be at least 18 or older to register");
        }

        // Insert code below that will talk to the Repository layer to store the newly registered user
        // ....

        // Check if user w/ username already exists
        if (authRepository.getUserByUsername(username) != null) {
            throw new UsernameAlreadyTakenException("Username is already taken");
        }

        User user = new User(username, password);
        authRepository.addUser(user);
    }


}
