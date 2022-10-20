import React, { useState } from 'react';
import PokemonBox, { IPokemon } from '../PokemonBox/PokemonBox';
import './PokemonList.css';

function PokemonList() {

    let newPokemon:IPokemon = {
        damage: 0,
        health: 0,
        img: "",
        level: 0,
        name: ""
    }

    const [listOfPoke, setListPoke] = useState<IPokemon[]>([
        {
            damage: 30,
            health: 10,
            img: 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/39.png',
            level: 20,
            name: "Jigglypuff"
        },
        {
            damage: 50,
            health: 1,
            img: 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/151.png',
            level: 10,
            name: 'Mew'
        },
        {
            damage: 10,
            health: 200,
            img: 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png',
            level: 2,
            name: 'Charmander'
        },
        {
            damage: 100,
            health: 1000,
            img: "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/143.png",
            level: 100,
            name: 'Snorlax'
        }
    ])

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
        
        <h2>Pokemon List</h2>
        <div className="grid-pokemon">
            {
                listOfPoke.map(poke => {
                    return <PokemonBox key={poke.name} {...poke}/>
                })
            }
        </div>
    </div>
}

export default PokemonList;