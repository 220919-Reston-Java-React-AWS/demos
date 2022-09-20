public class Driver {
    public static void main(String[] args) {
        //Control Flow Statements
        boolean myBool = true;
        boolean secondBool = false;

        //if, else if, else
        if(myBool){
            System.out.println("This is true");
        } else if (secondBool){
            System.out.println("This is the second bool checked in else if");
        } else {
            System.out.println("This is false");
        }

        //while
        int i = 0;
        while(i < 2){
            System.out.println("While loop is running" + i);
            i = i + 1;
        }

        //do-while runs at least once
        int j = 5;
        do {
            System.out.println("Do while loop ran"+ j);
            j = j - 1;
        }while(j > 2);

        for (int a = 0; a < 5; a++){
            System.out.println(a);
        }
        String myString = "Pablo";

        switch (myString) {
            case "Jaden":
                System.out.println("Case for Jaden");
                break;
            case "Pablo":
                System.out.println("Case for Pablo");
                break;
            default:
                System.out.println("This is the default case");
                break;
        }

        //Expressions/Operators
        System.out.println(1 == 1); //true

        System.out.println(1 > 1); //false
        System.out.println(1 < 1); //false
        System.out.println(1 >= 1); //true
        System.out.println(1 <= 1); //true
        System.out.println(!true == true); //false
        System.out.println((1 == 1) && (2 == 2)); //true
        System.out.println((1 == 1) && (2 == 3)); //false
        System.out.println((1 == 1) || (2 == 3)); //true
        System.out.println((1 == 2) || (2 == 3)); //false
        System.out.println(true ^ false); //true



    }
}
