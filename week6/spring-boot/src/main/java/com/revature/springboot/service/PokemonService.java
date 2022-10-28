package com.revature.springboot.service;

import java.util.Optional;

import com.revature.springboot.dao.PokemonBoxDao;
import com.revature.springboot.dao.PokemonDao;
import com.revature.springboot.model.Pokemon;
import com.revature.springboot.model.PokemonBox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PokemonService {
    
    @Autowired
    private PokemonDao pokeDao;

    @Autowired
    private PokemonBoxDao pokeBoxDao;


    /*
        Transactional annotation will create a new transaction to SQL
        It will have all the benefits of a transaction in SQL
        General rule - use it if you plan to execute multiple SQL statements 
    */
    @Transactional(propagation = Propagation.REQUIRED) //Will create a new transaction if there is not a current one running
    public Pokemon AddPokemon(Pokemon newPoke){

        //We are grabbing the PokemonBox object stored within pokemon object and grabbing its id
        Optional<PokemonBox> foundBox = pokeBoxDao.findById(newPoke.getPokemonBox().getBoxId());
        PokemonBox pokeBox;

        //If statement that checks if PokemonBox exists
        //If not, create a new one and store in database
        //If so, don't do anything
        if (foundBox.isEmpty()) {
            pokeBox = pokeBoxDao.save(new PokemonBox());
        }else {
            pokeBox = foundBox.get();
        }

        //Grab PokemonBox object from Pokemon Object and set its boxId to the autogenerated one from SQL
        newPoke.getPokemonBox().setBoxId(pokeBox.getBoxId());

        //Save the new Pokemon
        return pokeDao.save(newPoke);
    }

    public Pokemon GetPokeById(int id){
        Optional<Pokemon> foundPoke = pokeDao.findById(id);

        //With optional class in Java, we can check if what was given to us was a null
        //If it is, a simple if statement can change our behavior to avoid bugs or error-prone nulls
        if (foundPoke.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pokemon was not found");
        }else {
            return foundPoke.get();
        }
    }

    public Pokemon UpdatePokemon(Pokemon updatePoke){
        //Checking if Pokemon exists first, if not, give a status code of 404
        GetPokeById(updatePoke.getId());

        return pokeDao.save(updatePoke); //Save() method will either add a new resource or update an existing one
    }

    public void deletePokemon(int id){
        //Checking if Pokemon exists first
        Pokemon found = GetPokeById(id);

        pokeDao.delete(found);
    }
}