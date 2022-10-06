package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> myStrings = new ArrayList<>();

        myStrings.add("peach");
        myStrings.add("banana");
        myStrings.add("apple");

        System.out.println(myStrings);

        Collections.sort(myStrings); // TimSort O(n log n)

        System.out.println(myStrings);


        List<Person> people = new ArrayList<>();
        people.add(new Person("Aidan", "Z", 50));
        people.add(new Person("Pablo", "D", 30));
        people.add(new Person("Aidan", "S", 60));
        people.add(new Person("Jaden", "S", 15));
        people.add(new Person("Pablo", "A", 18));
        people.add(new Person("Bach", "T", 15));

        System.out.println(people);

        // Default ordering for Person objects is firstName, then lastName
        // That's because the Person class implements Comparable
        Collections.sort(people); // .sort() has no idea how to sort these Person objects because they don't have any inherent ordering

        System.out.println(people);

        Collections.sort(people, new PersonAgeComparator()); // sort by ages instead of using the default ordering. It will keep the original
        // relative ordering for things that are the same (items on the right will stay to the right of items on the left that are equal)
        // That's because Collections.sort uses a "stable sorting algorithm"

        System.out.println(people);
    }

}
