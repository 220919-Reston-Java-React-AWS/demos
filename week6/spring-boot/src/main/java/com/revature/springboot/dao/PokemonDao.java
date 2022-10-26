package com.revature.springboot.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.revature.springboot.model.Pokemon;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PokemonDao extends JpaRepository<Pokemon, Integer> {
    /*
        This is the power of Spring data, we now have all the capabilities to interact with your database with little to no coding
        You don't even need to know a single thing about SQL
        - This will have all the capabilities of a CRUD operation
        - .save(), .delete(), .find...() to name a few
        - We have complete abstraction over our DAO layer
    */
}
