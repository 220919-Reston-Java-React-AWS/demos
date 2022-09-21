package com.revature.exception;

public class UsernameAlreadyTakenException extends Exception { // IS-A Exception

    public UsernameAlreadyTakenException(String message) {
        super(message);
    }

}
