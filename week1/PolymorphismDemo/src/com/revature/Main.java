package com.revature;

import com.revature.model.Cat;
import com.revature.model.Dog;
import com.revature.model.Pet;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Pet p = new Cat("Whiskers");
        Pet p2 = new Dog("Sparky");

        System.out.println(p.name); // Whiskers
        System.out.println(p2.name); // Sparky

        p.play(); // Whiskers is playing with catnip!
        p2.play(); // Sparky is playing fetch!

        Pet obj = new Pet("Goldy");
        obj.play();

        obj = new Cat("Mittens");
        obj.play();

        obj = new Dog("Clifford");
        obj.play();

        System.out.println("Please select whether you would like to create a Pet, Dog, or Cat object:");
        System.out.println("1.) Pet object");
        System.out.println("2.) Dog object");
        System.out.println("3.) Cat object");

        Scanner sc = new Scanner(System.in);

        String choice = sc.nextLine();
        System.out.println("Enter a name you would like for the pet:");
        String name = sc.nextLine();

        Pet petChoice = null;
        if (choice.equals("1")) {
            petChoice = new Pet(name);
        } else if (choice.equals("2")) {
            petChoice = new Dog(name);
        } else if (choice.equals("3")) {
            petChoice = new Cat(name);
        }

        petChoice.play(); // play() depends on what Pet object the user chooses to make

        petChoice.eat();
        petChoice.eat(10);
        petChoice.eat("Steak");
        petChoice.eat(2, "Pork chops");
    }

}
