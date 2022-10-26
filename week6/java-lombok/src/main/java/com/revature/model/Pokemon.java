package com.revature.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
    @Getter - generates getters for your fields
    @Setter - generates setters for your fields
    @NoArgsConstructor - generates a default constructor
    @ToString - generates and overrides the toString method
    @EqualAndHashcode - generates and overrides the equal and hashcode methods
    @Data - Includes everything from above
*/
public @Data class Pokemon {
    @Setter(AccessLevel.NONE) private String name; //Accesslevel enum will help configure lombok to remove certain getters or setters
    private int level;
    private int health;
}
