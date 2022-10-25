package com.revature.service;

import com.revature.dao.AbilityDao;
import com.revature.dao.PokemonDao;

import org.springframework.stereotype.Component;

@Component
public class PokemonService {

    //=========== Dependency Injection Pattern ===========
    //Unlike XML, annotation will pass the right bean automatically for you as long as the bean exists
    private PokemonDao pokedao;
    private AbilityDao abilityDao;

    public PokemonService(PokemonDao pokedao, AbilityDao abilityDao) {
        this.pokedao = pokedao;
        this.abilityDao = abilityDao;

        System.out.println("Making Pokemon Service obj");
    }

    //====================================================
}
