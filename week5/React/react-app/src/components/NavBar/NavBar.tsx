import { Link } from 'react-router-dom';
import './NavBar.css';

function NarBar() {
    return <div className="flex">
        <Link to="/">Home</Link>
        <Link to="pokeList">Pokemon List</Link>
    </div>
}

export default NarBar;