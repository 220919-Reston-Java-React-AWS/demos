package com.revature;

import com.revature.model.Person;

public class Main {

    public static void main(String[] args) {
        Person p1 = new Person("John", "Doe", 25);
        /*
            toString()
         */
        System.out.println(p1); // When you print an object, it will actually print the String returned from the toString() method
        // toString() method returns a String with the format <classname>@<hashcode>

        String str1 = p1.toString();
        System.out.println(str1);

        Object o = p1; // o is pointing to the Person object we created on line 8
        System.out.println(o);

        /*
            equals()
         */
        Person pablo = new Person("Pablo", "De La Cruz", 50);
        Person bach = new Person("Bach", "Tran", 70);

        System.out.println(pablo.equals(bach)); // false
        System.out.println(pablo == bach); // false

        Person p = pablo;

        System.out.println(p.equals(pablo)); // true
        System.out.println(p == pablo); // true

        p.age = 51;
        System.out.println(pablo.age); // 51
        // -> Any change made via one variable is reflected on the other variable

        String s = new String("hello");
        String s2 = new String("hello");

        System.out.println(s.equals(s2)); // true
        System.out.println(s == s2); // false

        Person john = new Person("John", "Doe", 18);
        Person john2 = new Person("John", "Doe", 18);

        System.out.println(john.equals(john2)); // true
        System.out.println(john == john2); // false

        System.out.println(s.hashCode()); // 99162322
        System.out.println(s2.hashCode()); // 99162322
    }

}
