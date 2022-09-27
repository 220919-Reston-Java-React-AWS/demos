public class Main {
    public static void main(String[] args) {
        //Strings
        System.out.println("An Array Literal");

        String myString = "My String";
        System.out.println(myString);

        //String Exercise
        String red = "red";
        String red1 = "red";
        String red2 = new String("red");
        String blue = new String("blue");

        System.out.println(red);
        System.out.println(blue);

        char[] g = {'g','r','e','e','n'};

        //String from an array of characters
        String green = new String(g);
        System.out.println(green);

        //concat using +
        System.out.println(red+ " " + blue);

        //concat using .concat
        System.out.println(red.concat(blue));

        //.equals is similar to ==
        System.out.println(red.equals(blue));
        System.out.println(red.equals("red"));
        System.out.println(red == red2);

        //charAt
        System.out.println(red.charAt(0));

        //.length() invokes a method in String class
        System.out.println(red.length());

        String blue2 = new String(blue.substring(0,2));
        System.out.println(blue2);

        //Arrays

        int[] intArray = new int[4]; //[0,0,0,0]
        System.out.println(intArray[0]);

        //access elements inside an array using bracket notation
        intArray[1] = 11;
        System.out.println(intArray[0]);

        int[] intArray2 = {1,22,3,4};

        System.out.println(intArray2[1]);

        //iterate over an array
        for (int index = 0; index < intArray2.length; index++){
            System.out.println("Elements in intArray2: " + intArray2[index]);
        }

        // for in. Provides the value for the array.
        String[] arrString = {"first", "second", "third"};
        for(String e : arrString){
            System.out.println(e);
        }
    }
}