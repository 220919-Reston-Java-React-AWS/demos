package com.revature.repository;

import com.revature.model.User;

import java.util.*;

public class UserRepository {

    public static Map<String, User> users = new HashMap<>(); // We lose all User information if we restart the application
    // In the future, we will have the repository layer communicate with a database instead so that we can permanently
    // store User information into a SQL table

    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public List<User> getAllUsers() {
        List<User> results = new ArrayList<>();

        // Iterating through the Map via the keys
        // and adding each User object (values) to the List
        Set<String> keys = users.keySet();
        for (String k : keys) {
            results.add(users.get(k));
        }

        return results;
    }

}
