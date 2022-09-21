package com.revature.menu;

import com.revature.Main;

public class UserMenu {

    public void display() {
        while (true) {
            System.out.println("==== User Menu ====");
            System.out.println("1.) Submit Reimbursement Ticket");
            System.out.println("2.) Logout");

            String choice = Main.sc.nextLine();

            if (choice.equals("1")) {
                submitReimbursementPrompt();
            } else if (choice.equals("2")) {
                return;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    public void submitReimbursementPrompt() {
        // Prompt user for amount and description
    }

}
