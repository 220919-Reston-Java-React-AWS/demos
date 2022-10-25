import { Link } from 'react-router-dom';
import { useAppDispatch, useAppSelector } from '../../shared/hooks';
import { selectTrainer, setDefault } from '../Login/TrainerSlicer';
import './NavBar.css';

function NarBar() {
    const trainer = useAppSelector(selectTrainer);
    const dispatch = useAppDispatch();

    return <div className="flex">
        <Link to="/">Home</Link>
        <Link to="pokeList">Pokemon List</Link>
        {
            !trainer.name ? <Link to="login">Login</Link> : <div onClick={() => {dispatch(setDefault())}}>Logout</div>
        } 

        {
            trainer.name && <div>Welcome back {trainer.name}!</div>
        }
    </div>
}

export default NarBar;