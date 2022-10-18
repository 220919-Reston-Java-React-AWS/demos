/*
    Typescript needs to be installed via NPM
        - npm install -g typescript
        - Run PowerShell in Administrative mode, run the script `set-executionpolicy RemoteSigned` and accept

    Must transpile TS into JS for any web browser to use
        - tsc [TS filepath]
        - tsc -w [TS filepath] (Will transpile the file for you)
*/
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
console.log("Hello World");
console.log("=== Datatypes ===");
//We have strictly typing once again!
//int s1 = "Hello";
var n1 = 10;
console.log(n1);
//ANY - the default datatype of any declared variable, it is the same as JS
var a1;
a1 = "Hello";
a1 = 10;
a1 = true;
a1 = null;
a1 = 10.5;
//You can pair multiple datatypes into a single variable
var m1;
m1 = "Hello";
m1 = 10.5;
// m1 = true; //Will not work since a boolean is not a string or a number
//Arrays
var arr1;
arr1 = [true, "Helloo", 10.5];
console.log(arr1);
var arr2;
arr2 = [10.3, "Hello"];
var arr3;
arr3 = 10;
arr3 = ["Hello", "String"];
//Tuple - It is like an array but can only contain a fixed size and the order of the datatypes matter
var tul1;
tul1 = [10, "String", true];
tul1 = [20, "Hello", false];
//Enum - works like a normal enum in Java
//Enumes are used to make readability in code a lot easier
//We attach words with numbers essentially
var Engine;
(function (Engine) {
    Engine[Engine["Off"] = 0] = "Off";
    Engine[Engine["Accel"] = 1] = "Accel";
    Engine[Engine["Idle"] = 2] = "Idle";
})(Engine || (Engine = {}));
var engineState = 0;
if (engineState == Engine.Off) {
    //Can you guess what is the current state of the engine?
    //Using enum we can see in the if statement that this will execute the moment an engine is off
}
console.log("=== Functions ===");
//a colon after function will declare the datatype this function must return
function meFunc(param1, param2) {
    return param1 + param2;
}
meFunc(10, 10);
console.log("=== Abstraction ===");
var poke1 = {
    health: 100,
    level: 10,
    name: "Pikachu",
    damage: 10,
    talk: function () {
        console.log("Pika pika!");
    }
};
var poke2 = {
    health: 100,
    level: 10,
    name: "Ditto",
    talk: function () {
        console.log("Ditttooo");
    },
    optionalFunction: function () {
        console.log("Optional!");
    }
};
console.log(poke1.optionalFunction);
console.log(poke2.optionalFunction);
console.log("=== Class ===");
var Pokemon = /** @class */ (function () {
    function Pokemon() {
        //We have access modifiers back in typescript!
        this.speed = 99;
        this.species = "Mouse";
        this.name = "Pikachu";
        this.level = 10;
        this.health = 100;
        this.damage = 10;
    }
    Pokemon.prototype.talk = function () {
        throw new Error("Method not implemented.");
    };
    Pokemon.prototype.optionalFunction = function () {
        throw new Error("Method not implemented.");
    };
    return Pokemon;
}());
var poke3 = new Pokemon();
console.log(poke3);
console.log(poke3.name);
console.log(poke3.speed);
// console.log(poke3.species); This is an error because species is protected
var Electric = /** @class */ (function (_super) {
    __extends(Electric, _super);
    /**
     *
     */
    function Electric() {
        var _this = _super.call(this) || this;
        // We have access to species since it is a protected access member
        _this.species = "Electric";
        return _this;
    }
    return Electric;
}(Pokemon));
