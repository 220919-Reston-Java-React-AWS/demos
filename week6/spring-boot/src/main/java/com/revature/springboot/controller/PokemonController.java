package com.revature.springboot.controller;

import com.revature.springboot.model.Pokemon;
import com.revature.springboot.service.PokemonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //Specify that this bean will act like a restcontroller
@RequestMapping("/pokemon") //This will add url routing to your rest api
public class PokemonController {
    
    @Autowired
    PokemonService pokeServ;

    //@RequestMapping, when attached to a method, will help with routing HTTP request by checking their http verb as well as the URL
    //method determines the http verb to be used
    //value determins the url path to access this method
    // @PostMapping(value = "/add")
    // @GetMapping
    // @PutMapping
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public Pokemon AddPokemon(@RequestBody Pokemon newPoke){
        return pokeServ.AddPokemon(newPoke);    
    }

    //@PathVariable - Allow URL parameter to be passed in
    @RequestMapping(method = RequestMethod.GET, value="/{pokeId}")
    public Pokemon GetPokeById(@PathVariable("pokeId") int pokeId){
        return pokeServ.GetPokeById(pokeId);
    }

    //@RequestBody - Allow JSON parameter to be mapped
    @RequestMapping(method = RequestMethod.PUT, value="/update")
    public Pokemon UpdatePokemon(@RequestBody Pokemon updatePoke){
        return pokeServ.UpdatePokemon(updatePoke);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/delete/{pokeId}")
    public void DeletePokemon(@PathVariable("pokeId") int pokeId){
        pokeServ.deletePokemon(pokeId);
    }
}
