package com.revature.model;

public class User {

    public String username;
    public String password;

    // Constructor: used to populate initial values of the instance fields for a User object that we create
    public User(String un, String pw) {
        this.username = un;
        this.password = pw;
    }

}
