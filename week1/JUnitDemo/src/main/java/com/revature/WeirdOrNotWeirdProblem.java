package com.revature;

public class WeirdOrNotWeirdProblem {

    public String weirdOrNotWeird(int n) {
        if (n % 2 == 1) { // n is odd
            return "Weird";
        } else { //

            if (n >= 2 && n <= 5) {
                return "Not Weird";
            } else if (n >= 6 && n <= 20) {
                return "Weird";
            } else if (n > 20) {
                return "Not Weird";
            }

        }

        throw new IllegalArgumentException("n must be 1 or greater");
    }

}
