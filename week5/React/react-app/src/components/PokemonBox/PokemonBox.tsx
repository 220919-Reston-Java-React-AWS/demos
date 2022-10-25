import { useState } from "react";
import { IPokemon } from "../models/Pokemon";
import "./PokemonBox.css";
/*
    Will display pokemon information in Box UI

    It is not a good idea to make this component have hardcoded values because then it will give only pikachu
    Not really reusable

    Instead why not make our data dynamic?
*/

//So make sure to use inheritance since it will allow you to extend code without modifying it (modifying will leave problems in other places in your app)
interface IProp extends IPokemon{
    count:number,
    onButtonClick(infoToParent:string):void
}

function PokemonBox(props:IProp) {

    // If you want a univervsal value that all child component will share, you must put it on their common ancestry
    // const [count, setCount] = useState(0);

    return <div className="box">
        <img src={props.img}/>
        <h4>{props.name}</h4>
        <p>{props.count}</p>
        {/* 
            We are executing the callback function given to us by the parent component
            We can also pass a paramter to this callback function to be utilize by our parent component
            THIS IS CHILD TO PARENT COMMUNICATION
        */}
        <button onClick={() => {props.onButtonClick(props.name)}}>+</button>
        <p>Level: {props.level}</p>
        <p>Health: {props.health}</p>
        <p>Damage: {props.damage}</p>
    </div>
}

export default PokemonBox;