package com.revature;

import com.revature.model.Person;

public class Main {

    public static void main(String[] args) {
        Person p1 = new Person("John", "Doe", 21);
        Person p2 = new Person("Jane", "Doe", 30);

        p1.greet();
        p1.haveBirthdayParty();
        p1.greet();

        p2.greet();
        p2.haveBirthdayParty();
        p2.greet();

        // age is private, therefore we cannot directly and arbitrarily change age
        // p1.age = 10; // Changing John's age from 22 to 10
        p1.greet();
        p1.haveBirthdayParty();
        p1.greet();

        p1.setLastName("Smith");

        p1.greet();

        System.out.println(p1.getAge()); // 23
    }

}
