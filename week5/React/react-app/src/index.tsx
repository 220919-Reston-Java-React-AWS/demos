import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import FunctionalComponent from './components/FunctionalComponent';
import ClassComponent from './components/ClassComponent';
import PokemonBox, { IPokemon } from './components/PokemonBox/PokemonBox';
import Counter from './components/Counter/Counter';
import PokemonList from './components/PokemonList/PokemonList';

/*
  Index.tsx is your entry point of your components
  Anything in here is what will be displayed in your website

  Since React is SPA, this is going to the main HTML page (index.html) that will be serve first
*/

//You can see how React will select the div element from the index.html and from there will dynamically add in components
const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);

let pokemon:IPokemon = {
  damage: 10,
  health: 200,
  img: 'https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png',
  level: 2,
  name: 'Charmander'
}

let listOfPokemon:IPokemon[] = [
  {
    damage:30,
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
    name:'Mew'
  }
]

root.render(
  <React.StrictMode>
    {/* <Counter />
    <App />
    {/* <FunctionalComponent />
    <ClassComponent /> 
    <PokemonBox name="Pikachu" damage={10} health={100} img="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png" level={1}/>
    <PokemonBox {...pokemon}/>
     *}

    {
      /*
        map method will change each element from this array into 
        <PokemonBox />

        key attribute in React will give the component/jsx element a uniquely identified way to select it
        This is extremly for lists because React has a hard time dynamically changing information within a list
        They highly recommend you use key attribute and give each component/jsx element an id
      
      listOfPokemon.map((pokemon) => {
        return <PokemonBox key={pokemon.name} {...pokemon} />
      })
    */}

    <PokemonList />

  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
