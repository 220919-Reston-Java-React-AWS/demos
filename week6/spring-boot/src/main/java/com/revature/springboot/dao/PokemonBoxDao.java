package com.revature.springboot.dao;

import com.revature.springboot.model.PokemonBox;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonBoxDao extends JpaRepository<PokemonBox, Integer> {
    
}
