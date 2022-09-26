package com.revature.model;

public class PetHome<E> {

    // HAS-A relationship
    // PetHome HAS-A E (Dog, Cat, etc.)
    // ex. Car HAS-A Engine
    public E pet; // Parameterized field type (E)

    public E peek() { // Parameterized return type (E)
        return pet;
    }

}
