import React from "react";

/*
    Class components are just components made by using classes 
    Not supported as much by React because React shifted philosophy into thinking that
    React components must act like pure functions
*/

class ClassComponent extends React.Component {

    render() {
        return <div>
            The class component is working
        </div>
    }
}

export default ClassComponent;