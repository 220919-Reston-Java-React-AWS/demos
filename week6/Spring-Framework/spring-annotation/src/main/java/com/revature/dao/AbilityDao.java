package com.revature.dao;

import org.springframework.stereotype.Component;

@Component
public class AbilityDao {
    public AbilityDao() {
        System.out.println("Creating abilitydao obj");
    }

    public void someMethod() {
        System.out.println("Ability dao method is invoked");
    }
}
