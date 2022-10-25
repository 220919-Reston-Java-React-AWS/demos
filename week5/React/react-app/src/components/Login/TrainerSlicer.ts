import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { RootState } from "../../shared/store";
import { ITrainerModel } from "../models/TrainerModel";

//initialState would be the default value of the state you are storing in the store
//Attaching this with a model will enforce strictly typing so I highly encourage you do so
const initialState: ITrainerModel = {
    id: 0,
    listOfPokemon: [],
    name: "",
    totalBadge: 0
}

const trainerSlice = createSlice({
    name:"trainer",
    initialState,


    /*
        Since the store is immutable, we need to dictate to Redux how we want to change the information stored in the store

        Redux action is an object that will contain the informatin we need to change our current state in some shape or form
        They call it "action" because every time you sent information from the view is done usually by doing some sort of action
    */
    reducers: {
        setTrainer: (state, action: PayloadAction<ITrainerModel>) => {
            //state parameter is the information stored in the store

            //THIS WILL NOT WORK
            // state = action.payload;

            //This will work because we are changing the individual properties of the state object instead of changing what it is pointing at
            state.name = action.payload.name;
            state.id = action.payload.id;
            state.listOfPokemon = action.payload.listOfPokemon;
            state.totalBadge = action.payload.totalBadge;
        },
        //You can setup more types of reducers, not all reducers need a payload/action
        //This will be used to logout
        setDefault: (state) => {
            state.id = 0;
            state.listOfPokemon = [];
            state.name = "";
            state.totalBadge = 0;
        }
    }
})

// We want to export everything so every component will have access to our reducers
export const {setTrainer, setDefault} = trainerSlice.actions;

//This will be used by our store to access the slicer's reducer
export default trainerSlice.reducer;

//Letting our component have access to the store's current information of the state
export const selectTrainer = (state:RootState) => state.trainer;