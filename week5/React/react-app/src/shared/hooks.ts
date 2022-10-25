/*
    Unfortunately, React redux doesn't fully support TS all the way
    So, we have extra configuration to enforce TS behavior
    Basically, we are setting strict typing from the JS version of methods
*/

import { TypedUseSelectorHook, useDispatch, useSelector } from "react-redux";
import { AppDispatch, RootState } from "./store";

export const useAppDispatch: () => AppDispatch = useDispatch;
export const useAppSelector: TypedUseSelectorHook<RootState> = useSelector;