package com.revature.petexample;

public class Cat extends Pet implements Meowable {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println(name + " is playing with catnip!");
    }

    @Override
    public void meow() {
        System.out.println("Meow!");
    }

}
