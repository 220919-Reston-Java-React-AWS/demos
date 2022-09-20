import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the calculator application");
        System.out.println("1.) Add two numbers");
        System.out.println("2.) Multiply two numbers");
        System.out.println("3.) Subtract two numbers");
        System.out.println("4.) Divide two numbers");
        System.out.println("Enter a choice (1 - 4)");

        int choice = sc.nextInt();
        sc.nextLine();

        // Instead of using switch statements, we could also use if, else if, else

        switch (choice) {
            case 1:
                System.out.println("Enter the first number you would like to add");
                int a = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter the second number you would like to add");
                int b = sc.nextInt();
                sc.nextLine();

                System.out.println("The result is " + (a + b));
                break;
            case 2:
                System.out.println("Enter the first number you would like to multiply");
                int a2 = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter the second number you would like to multiply");
                int b2 = sc.nextInt();
                sc.nextLine();

                System.out.println("The result is " + (a2 * b2));

                break;
            case 3:
                System.out.println("Enter the first number you would like to subtract");
                int a3 = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter the second number you would like to subtract");
                int b3 = sc.nextInt();
                sc.nextLine();

                System.out.println("The result is " + (a3 - b3));

                break;
            case 4:
                System.out.println("Enter the first number you would like to divide");
                int a4 = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter the second number you would like to divide");
                int b4 = sc.nextInt();
                sc.nextLine();

                System.out.println("The result is " + (a4 / b4));

                break;
            default:
                System.out.println("Invalid choice");
        }

    }
}