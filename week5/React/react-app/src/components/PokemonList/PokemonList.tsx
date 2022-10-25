import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useAppSelector } from '../../shared/hooks';
import { selectTrainer } from '../Login/TrainerSlicer';
import { IPokemon } from '../models/Pokemon';
import { IPokemonApi } from '../models/PokemonApi';
import PokemonBox from '../PokemonBox/PokemonBox';
import './PokemonList.css';

function PokemonList() {

    const trainer = useAppSelector(selectTrainer);

    let newPokemon:IPokemon = {
        damage: 0,
        health: 0,
        img: "",
        level: 0,
        name: ""
    }

    //We have lifted the state by putting it on the parent component
    const [count, setCount] = useState(0);

    const [listOfPoke, setListPoke] = useState<IPokemon[]>(trainer.listOfPokemon);

    
    /*
        useEffect is a hook that will execute the behavior if one of the event happens:
            - initial rendering of the component
            - after the rendering of the component
            - a change in the primitive datatype of a state
        BE CAREFUL, useEffect can cause an infinite loop if the behavior of your useEffect also changes the value of a primitive type state
    */
    useEffect(() => {
        setListPoke(trainer.listOfPokemon);
    });

    function setName(event: React.ChangeEvent<HTMLInputElement>) {
        newPokemon.name = event.target.value;

        console.log(newPokemon.name);
    }

    function setLevel(event: React.ChangeEvent<HTMLInputElement>) {
        newPokemon.level = +event.target.value;
    }

    function setHealth(event: React.ChangeEvent<HTMLInputElement>) {
        newPokemon.health = +event.target.value;
    }

    function setDamage(event: React.ChangeEvent<HTMLInputElement>) {
        newPokemon.damage = +event.target.value;
    }

    function setImage(event: React.ChangeEvent<HTMLInputElement>) {
        newPokemon.img = event.target.value;
    }

    function onSubmit(event: React.FormEvent<HTMLFormElement>){
        event.preventDefault();

        console.log(listOfPoke);

        setListPoke([newPokemon, ...listOfPoke]);
    }

    function setNameP(event: React.ChangeEvent<HTMLInputElement>) {
        newPokemon.name = event.target.value;
    }

    function onSubmitP(event: React.FormEvent<HTMLFormElement>){
        event.preventDefault();

        //Axios to grab information from the pokeAPI and storing it
        //Axios has the capability to map things for you if you models/interface
        axios.get<IPokemonApi>(`https://pokeapi.co/api/v2/pokemon/${newPokemon.name}`)
            .then(response => {
                console.log(response.data);

                //Converting PokemonAPI into Pokemon
                let poke:IPokemon = {
                    damage:response.data.stats[1].base_stat,
                    health:response.data.stats[0].base_stat,
                    img:response.data.sprites.front_default,
                    level:10,
                    name:response.data.name
                }

                console.log(poke);

                //Adding Pokemon to our list
                setListPoke([poke, ...listOfPoke]);

            })
        
        
    }

    function handleOnClickEvent(infoFromChild:string) {
        setCount(count+1);

        console.log(infoFromChild);
    }

    return <div>
        <h3>Add Pokemon</h3>
        <form className="grid" onSubmit={onSubmit}>
            <label>Name</label>
            <input type="text" onChange={setName}></input>
            <label>level</label>
            <input type="number" onChange={setLevel}></input>
            <label>Health</label>
            <input type="number" onChange={setHealth}></input>
            <label>Damage</label>
            <input type="number" onChange={setDamage}></input>
            <label>Image</label>
            <input type="text" onChange={setImage}></input>
            <br/>
            <input type="submit" value="Add Pokemon"/>
        </form>

        <h3>Add Pokemon via PokeAPI</h3>
        <form className="grid" onSubmit={onSubmitP}>
            <label>Name</label>
            <input type="text" onChange={setNameP}></input>
            <br/>
            <input type="submit"></input>
        </form>
        
        <h2>Pokemon List</h2>
        <div className="grid-pokemon">
            {
                listOfPoke.map(poke => {

                    // We pass the function from the parent to the child component as a callback function
                    return <PokemonBox key={poke.name} {...poke} count={count} onButtonClick={handleOnClickEvent}/>
                })
            }
        </div>
    </div>
}

export default PokemonList;