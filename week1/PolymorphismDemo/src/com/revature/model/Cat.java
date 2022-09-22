package com.revature.model;

public class Cat extends Pet {

    public Cat(String name) {
        super(name); // pass name to parent class constructor
    }

    @Override
    public void play() {
        System.out.println(super.name + " is playing with catnip!");
    }

}
