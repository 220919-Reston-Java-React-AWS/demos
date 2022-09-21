package com.revature.menu;

import com.revature.Main; // we are importing the Main class from the com.revature package

public class MainMenu {

    public void display() {
        while (true) {
            System.out.println("Welcome to the employee reimbursement system");
            System.out.println("Please select an option:");
            System.out.println("1.) Register");
            System.out.println("2.) Login");
            System.out.println("3.) Exit");

            String choice = Main.sc.nextLine();

            if (choice.equals("1")) {
                // Redirect to registration prompt
                System.out.println("Redirect to Registration");
            } else if (choice.equals("2")) {
                // Redirect to login prompt
                System.out.println("Redirect to Login");
            } else if (choice.equals("3")) {
                return; // Stop execution of the method
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

}
