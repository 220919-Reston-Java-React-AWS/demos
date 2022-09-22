package com.revature.model;

import java.util.Objects;

public class Person { // Person extends Object (implicitly)

    // If you don't set any value for fields, fields will take on default values
    // numbers -> 0 or 0.0
    // reference types -> null
    // booleans -> false
    // chars are technically numbers that represent a single character

    public String firstName;
    public String lastName;
    public int age;

    // Default no-args constructor
    // - Is provided IF AND ONLY IF there is no constructor explicitly defined by the programmer
    public Person() {
    }

    public Person(String fn, String ln, int a) {
        this.firstName = fn;
        this.lastName = ln;
        this.age = a;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age); // the hashCode is generated from the values of firstName, lastName, and age
    }

//    @Override // @Override is not required to override a method, but it will let you know if you're not actually overriding anything
//    // for example, if you made a typo in the method name
//    public String toString() {
//        return "firstName = " + firstName + ", lastName = " + lastName + ", age = " + age;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (o instanceof Person) { // Type-safety
//            Person p = (Person) o; // Downcasting (when you're casting a reference variable, you're not changing the object's type)
//            // What you are doing is changing the reference variable type
//
//            return this.firstName.equals(p.firstName) && this.lastName.equals(p.lastName) && this.age == p.age;
//        } else {
//            return false; // If it's not a Person, we know they're already not "equal"
//        }
//    }

}
