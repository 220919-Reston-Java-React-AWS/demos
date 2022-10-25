package com.revature.service;

import com.revature.dao.AbilityDao;
import com.revature.dao.PokemonDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
    What if you don't want to use DI Design Pattern to let Spring know what this object depends on?
*/

@Component
public class AbilityService {

    /*
        Another way to inject dependencies is by adding a @Autowire into a field
        TLDR: Autowire annotation is used to inject beans that currently exist
            - it can applied to field, setter, or even a constructor
    */
    @Autowired
    private AbilityDao abilitydao;

    @Autowired
    private PokemonDao pokemonDao;

    public void someMethod() {
        abilitydao.someMethod();
    }
}
