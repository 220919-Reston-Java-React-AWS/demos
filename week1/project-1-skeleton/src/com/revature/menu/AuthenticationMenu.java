package com.revature.menu;

import com.revature.Main;
import com.revature.exception.NotOldEnoughException;
import com.revature.exception.UsernameAlreadyTakenException;
import com.revature.model.User;
import com.revature.service.AuthService;

public class AuthenticationMenu {

    public AuthService as = new AuthService();

    public void display() {
        while (true) {
            System.out.println("==== Authentication Menu ====");
            System.out.println("1.) Login");
            System.out.println("2.) Register");
            System.out.println("3.) Back");

            String choice = Main.sc.nextLine();

            if (choice.equals("1")) {
                // Display the login prompt
                loginPrompt();
            } else if (choice.equals("2")) {
                // Display the registration prompt
                registerPrompt();
            } else if (choice.equals("3")) {
                return;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    public void loginPrompt() {
        System.out.println("Enter your username:");
        String username = Main.sc.nextLine();

        System.out.println("Enter your password:");
        String password = Main.sc.nextLine();

        // Insert code below that will check to see if the username and password are valid
//        if (...) {
//            // navigate to UserMenu
//        }
    }

    public void registerPrompt() {
        // Ask for the username + password + age of the user that would like to register

        while (true) {

            try {
                // Asking for age is not the best idea, in a real situation you may ask for their birthday instead
                System.out.println("Enter the username you would like to sign up with:");
                String username = Main.sc.nextLine();

                System.out.println("Enter the password you would like to sign up with:");
                String password = Main.sc.nextLine();

                System.out.println("Enter your age:");
                String age = Main.sc.nextLine();

                as.register(username, password, age); // IllegalArgumentException may be thrown from this register method

                System.out.println("Successfully registered");

                break; // break out of while loop
            } catch (NotOldEnoughException | UsernameAlreadyTakenException e) {
                System.out.println(e.getMessage());
                System.out.println("Please try again!");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input for age");
                System.out.println("Please try again!");
            }
        }

    }

}
