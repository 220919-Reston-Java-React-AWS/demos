package com.revature.model;

public class Cat {

    public String name;

    public Cat(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println(name + " says meow!");
    }

}
