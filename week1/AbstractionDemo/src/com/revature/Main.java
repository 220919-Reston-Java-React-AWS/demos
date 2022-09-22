package com.revature;

import com.revature.petexample.Cat;
import com.revature.petexample.Dog;
import com.revature.petexample.Pet;
import com.revature.shapeexample.*;

public class Main {

    public static void main(String[] args) {
        Shape s = new Circle(10);

        System.out.println(s.getArea()); // 314....
        // All 3 pillars that we have covered so far are being used
        // 1. Inheritance
        // 2. Polymorphism
        // 3. Abstraction

        // Not using Encapsulation

        s = new Rectangle(15, 5);
        System.out.println(s.getArea());

        s = new Square(5);
        System.out.println(s.getArea());

        s = new Triangle(10, 20);
        System.out.println(s.getArea());

        Pet p = new Dog("Fido");
        p.play();

        if (p instanceof Dog) { // type-safety check
            ((Dog) p).bark();
        }

        p = new Cat("Whiskers");

        if (p instanceof Cat) { // type-safety check
            ((Cat) p).meow();
        }
    }

}
