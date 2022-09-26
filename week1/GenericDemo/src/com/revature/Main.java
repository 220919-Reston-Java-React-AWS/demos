package com.revature;

import com.revature.model.Cat;
import com.revature.model.Dog;
import com.revature.model.PetHome;

public class Main {

    public static void main(String[] args) {
        Dog d1 = new Dog("Fido");
        Cat c1 = new Cat("Whiskers");

        PetHome<Dog> dogHouse = new PetHome();
        dogHouse.pet = d1;
        dogHouse.peek().bark(); // Return type of .peek() is Dog

        PetHome<Cat> catHouse = new PetHome();
        catHouse.pet = c1;
        catHouse.peek().meow(); // Return type of .peek() is Cat
    }

}
