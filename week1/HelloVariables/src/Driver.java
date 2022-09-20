public class Driver {
    public static void main(String[] args) {
        //This is a comment line. The compiler will ignore anything after //

        /*
        This
        is multi line comments
         */

        //Primitives:

        //Here we declare a variable called myBool as a boolean type
        boolean myBool = false;
        System.out.println(myBool);

        //whole number
        byte myByte = 123;
        System.out.println(myByte);

        short myShort = 120;
        System.out.println(myShort);

        int i = 123413;
        System.out.println(i);

        long myLong = 3213127234213L;
        System.out.println(myLong);

        //decimal values
        float myFloat = 13.33f;
        System.out.println(myFloat);

        double myDouble = 33.21;
        System.out.println(myDouble);

        //require single quotes. double quotes is for strings
        char myChar = 'c';
        System.out.println(myChar);

        //Rollover

        byte myByte2 = 100; //123+100 = 223

        myByte = (byte) (myByte + myByte2);

        System.out.println(myByte);


    }
}
