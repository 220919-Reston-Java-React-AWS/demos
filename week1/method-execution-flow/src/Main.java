public class Main {

    public static void main(String[] args) {
        int result = a();

        System.out.println(result);
    }
    // When the main method is totally finished executing,
    // the program is done

    public static int a() {
        System.out.println("a() is running");
        int sum = b() + c();

        return sum;
    }

    public static int b() {
        System.out.println("b() is running");
        return 5;
    }

    public static int c() {
        System.out.println("c() is running");
        return 6;
    }

}