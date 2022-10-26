package com.revature.dao;

import org.springframework.stereotype.Component;

//@Component //@Component will declare to Spring to make a bean out of this class
public class PokemonDao {
    public PokemonDao() {
        System.out.println("Creating PokemonDao obj");
    }
}
