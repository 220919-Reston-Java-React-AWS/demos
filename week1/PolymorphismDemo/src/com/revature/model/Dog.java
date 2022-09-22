package com.revature.model;

public class Dog extends Pet {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println(super.name + " is playing fetch!");
    }

}
