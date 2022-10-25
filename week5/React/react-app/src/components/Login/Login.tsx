import axios from 'axios';
import { useState } from 'react';
import { useAppDispatch, useAppSelector } from '../../shared/hooks';
import { ITrainerModel } from '../models/TrainerModel';
import {selectTrainer, setTrainer} from './TrainerSlicer';
import './Login.css';

function Login() {
    //We are grabbing the trainer state from the store using useAppSelector
    const trainer = useAppSelector(selectTrainer);

    const dispatch = useAppDispatch();

    const [trainId, setTrainId] = useState<number>(0);

    function onSubmit(event: React.FormEvent<HTMLFormElement>) {
        event.preventDefault();

        //Axios to interact with the backend to "login"
        axios.get<ITrainerModel>(`http://smresteb-env.eba-u2i9uhvs.us-east-1.elasticbeanstalk.com/rest/getUserPokemon?id=${trainId}`)
            .then(response => {
                console.log(response);

                //We are sending a dispatch to Redux Reducer to change the Trainer state stored in the store using reducers
                dispatch(setTrainer(response.data));
            })
    }

    return <div>
        <h1>Login</h1>

        <form className="grid" onSubmit={onSubmit}>
            <label>Trainer Id</label>
            <input type="number" onChange={(event) => {setTrainId(+event.target.value)}}/>
            <br/>
            <input type="submit" value="login" />
        </form>
    </div>
}

export default Login;