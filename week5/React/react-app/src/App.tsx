import React from 'react';
import logo from './logo.svg';
import './App.css';

/*
  This is what a component looks like

  The name of the component will be the name of the function itself
  so to reference this component `<App />`
*/

function App() {

  /*
    the function returns something that looks like HTML but it is NOT HTML

    JSX / TSX
    Essentially, it is a new language that combines both HTML and JS together seamlessly
      - Ex: Want to put a HTML element inside a variable? You can
        You want to use a variable value inside an HTML? Yep

    You can only return one parent element in JSX
  */

  let paragraph = <p>Wow I am storing an HTML within a JS variable??!</p>;

  let someValue = "Hello I am a string variable";

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />

        {paragraph}
        <p>
          Edit <code>src/App.tsx</code> and save to reload.
          {someValue}
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

export default App;
