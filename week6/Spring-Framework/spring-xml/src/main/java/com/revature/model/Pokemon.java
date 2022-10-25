package com.revature.model;

public class Pokemon {

    private String name;
    private int level;
    private int health;
    
    public Pokemon() {
        System.out.println("Creating an instance out of " + Pokemon.class);
        
    }

    public Pokemon(String name, int level, int health) {
        this();
        this.name = name;
        this.level = level;
        this.health = health;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "Pokemon [health=" + health + ", level=" + level + ", name=" + name + "]";
    }

    
    
}
