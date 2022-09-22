package com.revature.model;

public class Pet {

    public String name;

    public Pet(String name) {
        super(); // invoke Object class constructor
        this.name = name;
    }

    public void play() {
        System.out.println(name + " is playing!");
    }

    // Method overloading
    // 2 or more methods in the same class with the same name
    public void eat() {
        System.out.println(name + " is eating!");
    }

    public void eat(String food) {
        System.out.println(name + " is eating " + food + "!");
    }

    public void eat(int amount) {
        System.out.println(name + " is eating " + amount + " units of food!");
    }

    public void eat(int amount, String food) {
        System.out.println(name + " is eating " + amount + " pieces of " + food + "!");
    }

}
