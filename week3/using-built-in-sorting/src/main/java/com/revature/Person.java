package com.revature;

import java.util.Objects;

public class Person implements Comparable<Person> {

    private String firstName;
    private String lastName;

    private int age;

    public Person() {
    }

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // compareTo essentially compares "this" object to another Person object to see which one is "greater" than the other
    // it returns an int
    // the return value can be 0, >0, or <0
    // >0: "this" object is greater than the other object
    // <0: "this" object is less than the other object
    // 0: "this" object is the same "rank" as the other object
    @Override
    public int compareTo(Person o) {
        // Sort people by firstName, but if they have the same firstName, then sort by lastName
        if (this.firstName.compareTo(o.firstName) == 0) {
            return this.lastName.compareTo(o.lastName);
        }

        return this.firstName.compareTo(o.firstName);
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
        return Objects.hash(firstName, lastName, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
