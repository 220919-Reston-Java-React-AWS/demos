package com.revature.dao;

public class PokemonDao {

    public PokemonDao() {
        System.out.println("Creating an instance out of " + PokemonDao.class);
    }

    public void someGetMethod() {
        System.out.println("Getting Pokemons");
    }

    public void customInitializationMethod() {
        System.out.println("Custom Initialization is executed!");
    }

    public void customDestroyMethod() {
        System.out.println("Custom destroy is executed!");
    }
}
