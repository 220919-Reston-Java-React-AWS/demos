package com.revature.menu;

import com.revature.Main; // we are importing the Main class from the com.revature package

public class MainMenu {

    public void display() {
        while (true) {
            System.out.println("Welcome to the employee reimbursement system");
            System.out.println("Please select an option:");
            System.out.println("1.) Authenticate");
            System.out.println("2.) About Us");
            System.out.println("3.) Exit");

            String choice = Main.sc.nextLine();

            if (choice.equals("1")) {
                // Redirect to AuthenticationMenu
                AuthenticationMenu authMenuObject = new AuthenticationMenu();
                authMenuObject.display();
            } else if (choice.equals("2")) {
                // Redirect to AboutUsMenu
                AboutUsMenu aboutUsMenuObject = new AboutUsMenu();
                aboutUsMenuObject.display();
            } else if (choice.equals("3")) {
                return; // Stop execution of the method
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

}
