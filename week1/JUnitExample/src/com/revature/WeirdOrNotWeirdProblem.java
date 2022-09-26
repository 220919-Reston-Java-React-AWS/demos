package com.revature;

public class WeirdOrNotWeirdProblem {

    public static String weirdOrNotWeird(int x) {
        if (x % 2 == 1) {
            return "Weird";
        } else if (x >= 2 && x <= 5) {
            return "Not Weird";
        } else if (x >= 6 && x <= 20) {
            return "Weird";
        } else if (x > 20) {
            return "Not Weird";
        }

        throw new IllegalArgumentException("number provided must be positive (1 or greater)");
    }

}
