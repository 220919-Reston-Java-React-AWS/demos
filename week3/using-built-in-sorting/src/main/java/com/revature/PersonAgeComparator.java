package com.revature;

import java.util.Comparator;

public class PersonAgeComparator implements Comparator<Person> {

    // 0: same rank
    // >0: higher rank
    // <0: lower rank
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
    }

}
