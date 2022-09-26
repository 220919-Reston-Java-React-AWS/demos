package com.revature.model;

public class Person {

    private String firstName; // default value null
    private String lastName; // default value null
    private int age; // default value 0

    public Person() { // no-args constructor
    }

    public Person(String fn, String ln, int a) { // parameterized constructor
        this.firstName = fn;
        this.lastName = ln;
        this.age = a;
    }

    public void greet() {
        System.out.println("Hi! My name is " + firstName + " " + lastName + ", and I am " + age + " years old");
    }

    public void haveBirthdayParty() {
        System.out.println(firstName + " " + lastName + " is having their birthday");
        age++;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
