import { useState } from "react";

function Counter() {

    // Changing the value of a variable directly will not cause React to re-render the website
    //States are Immutable!! Changing directly does not do anything
    // let currentCount = 10;

    /*
        useState(parameter) the parameter will set the default value of the state
        - It gives you the state and a function to change the value of the state (because of its weird immutable property)
    */
    let [currentCount, setCount] = useState(1);

    function increment() {
        setCount(currentCount + 1)
        console.log(currentCount);
    }

    return <div>
        <p>{currentCount}</p>
        <button onClick={increment}>Click me</button>
    </div>
}

export default Counter;