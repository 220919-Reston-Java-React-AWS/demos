package com.revature.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

/*
    @Entity - marks this class as something that should be mapped into our database
        -name will dictate the name of the table Spring data will generate for you
*/

@Entity(name="Pokemon")
public @Data class Pokemon {

    @Id //Would specify that this field should be primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Will auto-generate the primary key (depending on its datatype)
    private int id;
    private String name;
    private int level;
    private int health;
    private int damage;
    private int speed;
    
    @ManyToOne
    @JoinColumn(name="boxId", nullable = false)
    private PokemonBox pokemonBox;

    public Pokemon() {
        
    }

    public Pokemon(int id) {
        this.id = id;
    }

    public Pokemon(String name, int level, int health, int damage, int speed) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.damage = damage;
        this.speed = speed;
    }

    
}
