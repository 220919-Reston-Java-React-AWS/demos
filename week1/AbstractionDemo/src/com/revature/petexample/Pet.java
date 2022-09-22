package com.revature.petexample;

public abstract class Pet {

    public String name;

    // Abstract classes can have constructors even though you cannot directly use the constructor to instantiate an object
    public Pet(String name) {
        this.name = name;
    }

    public abstract void play();

}
