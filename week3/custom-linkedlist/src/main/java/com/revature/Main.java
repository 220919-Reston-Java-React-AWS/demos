package com.revature;

public class Main {

    public static void main(String[] args) {
        MyLinkedList<Integer> myInts = new MyLinkedList<>();

        myInts.add(10);
        myInts.add(20);
        myInts.add(30);
        myInts.add(40);
        myInts.add(50);
        myInts.add(60);

        System.out.println(myInts.get(0)); // 10
        System.out.println(myInts.get(1)); // 20
        System.out.println(myInts.get(2)); // 30
        System.out.println(myInts.get(3)); // 40
        System.out.println(myInts.get(4)); // 50
        System.out.println(myInts.get(5)); // 60
    }

}
