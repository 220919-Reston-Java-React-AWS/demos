package com.revature.menu;

import com.revature.Main;

public class AboutUsMenu {

    public void display() {
        while (true) { // Infinite loop
            System.out.println("This is the reimbursement system for Revature LLC. You can register for an account and log in in order " +
                    "to submit reimbursements");
            System.out.println("1.) Back");

            String choice = Main.sc.nextLine();

            if (choice.equals("1")) { // == compares memory addresses
                // If you want to compare two string objects to see if they have the same value, you must use .equals() method
                return;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

}
