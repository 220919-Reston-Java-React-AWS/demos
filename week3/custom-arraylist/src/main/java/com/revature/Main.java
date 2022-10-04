package com.revature;

public class Main {

    public static void main(String[] args) {
        MyArrayList<Integer> myInts = new MyArrayList<>();

        myInts.add(10);
        myInts.add(25);
        myInts.add(30);
        myInts.add(-10);
        myInts.add(40); // the old array should have reached its maximum capacity, so the 1.5x increase operation should occur

        System.out.println(myInts.get(0)); // 10
        System.out.println(myInts.get(1)); // 25
        System.out.println(myInts.get(2)); // 30
        System.out.println(myInts.get(3)); // -10
        System.out.println(myInts.get(4)); // 40

        // Overridden toString() method
        System.out.println(myInts); // [ 10, 25, 30, -10, 40 ]

        myInts.add(100);
        myInts.add(200);
        myInts.add(101);
        myInts.add(1000);

        System.out.println(myInts);
    }

}
