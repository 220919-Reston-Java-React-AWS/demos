import { configureStore } from "@reduxjs/toolkit";
import TrainerSlicer from "../components/Login/TrainerSlicer";

export const store = configureStore({
    reducer: {
        trainer: TrainerSlicer
    }
})

/*
    Unfortunately, React redux doesn't fully support TS all the way
    So, we have extra configuration to enforce TS behavior
    Basically, we are setting strict typing from the JS version of methods
*/
export type AppDispatch = typeof store.dispatch
export type RootState = ReturnType<typeof store.getState>