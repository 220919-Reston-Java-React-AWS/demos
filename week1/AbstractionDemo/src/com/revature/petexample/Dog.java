package com.revature.petexample;

public class Dog extends Pet implements Barkable {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println(name + " is playing fetch!");
    }

    @Override
    public void bark() {
        System.out.println(Barkable.noise);
    }

}
