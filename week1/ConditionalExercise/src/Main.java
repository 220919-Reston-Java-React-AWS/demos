import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // System.in is "standard input" = whatever the user inputs from the console
        // System.out is "standard output" = console

        // Exercise:
        System.out.println("Enter the temperature of the water in Fahrenheit: ");
        int temperatureOfWater = sc.nextInt(); // Fahrenheit

        // "It is boiling"
        // "It is frozen"
        // "It is liquid"

        // System.out.println("...");

        if (temperatureOfWater >= 212) {
            System.out.println("It is boiling");
        } else if (temperatureOfWater <= 32) {
            System.out.println("It is frozen");
        } else {
            System.out.println("It is liquid");
        }

        // conditionals: use your logical skills in helping you craft your conditional statements

    }
}