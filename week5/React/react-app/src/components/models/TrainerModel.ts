import { IPokemonModel } from "./PokemonModel";

export interface ITrainerModel {
    id:number,
    name:string,
    totalBadge:number,
    listOfPokemon:IPokemonModel[]
}