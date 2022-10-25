package com.revature.service;

import com.revature.dao.PokemonDao;

public class PokemonService {

    //===================== Dependency Injection =====================

    //A class that needs another class
    //This is essentially a dependency
    private PokemonDao pokedao; //pokedao is holding what? null
    
    public PokemonService(PokemonDao pokeDao) {
        System.out.println("Creating an object out of " + PokemonService.class);
        this.pokedao = pokeDao;
    }

    //===============================================================

    public void GetPokemons() {
        pokedao.someGetMethod();
    }
}
