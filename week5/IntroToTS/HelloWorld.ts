/*
    Typescript needs to be installed via NPM
        - npm install -g typescript
        - Run PowerShell in Administrative mode, run the script `set-executionpolicy RemoteSigned` and accept

    Must transpile TS into JS for any web browser to use
        - tsc [TS filepath]
        - tsc -w [TS filepath] (Will transpile the file for you)
*/

console.log("Hello World");

console.log("=== Datatypes ===")

//We have strictly typing once again!
//int s1 = "Hello";
let n1:number = 10;

console.log(n1);

//ANY - the default datatype of any declared variable, it is the same as JS
let a1:any;
a1 = "Hello";
a1 = 10;
a1 = true;
a1 = null;
a1 = 10.5;

//You can pair multiple datatypes into a single variable
let m1: string | number;
m1 = "Hello";
m1 = 10.5;
// m1 = true; //Will not work since a boolean is not a string or a number

//Arrays
let arr1: any[];
arr1 = [true, "Helloo", 10.5];
console.log(arr1);

let arr2 : (number | string)[]
arr2 = [10.3, "Hello"];

let arr3: number | string[]
arr3 = 10;
arr3 = ["Hello", "String"];

//Tuple - It is like an array but can only contain a fixed size and the order of the datatypes matter
let tul1: [number, string, boolean]
tul1 = [10, "String", true];

tul1 = [20, "Hello", false];

//Enum - works like a normal enum in Java
//Enumes are used to make readability in code a lot easier
//We attach words with numbers essentially
enum Engine {
    Off = 0,
    Accel = 1,
    Idle = 2
}

let engineState:number = 0;

if (engineState == Engine.Off) {
    //Can you guess what is the current state of the engine?
    //Using enum we can see in the if statement that this will execute the moment an engine is off
}

console.log("=== Functions ===");


//a colon after function will declare the datatype this function must return
function meFunc(param1:number, param2:number) : number {
    return param1+param2;
}

meFunc(10, 10);

console.log("=== Abstraction ===");

//A great way for reusability
//A great way to ensure that whatever objects you are making from will follow all the properties this interface has
//Since we have interface, we have abstraction back once again
interface IPokemon {
    name:string,
    level:number,
    health:number,
    damage?:number, //Adding '?' will give it an optional property
    talk():void, //Like interface in Java, you are not required provide implementation details

    optionalFunction?():void;
}

let poke1:IPokemon = {
    health: 100,
    level: 10,
    name: "Pikachu",
    damage: 10,
    talk: function () {
        console.log("Pika pika!")
    }
};

let poke2: IPokemon = {
    health: 100,
    level: 10,
    name: "Ditto",
    talk: function () {
        console.log("Ditttooo");
    },
    optionalFunction: function () {
        console.log("Optional!");
    }
}

console.log(poke1.optionalFunction);
console.log(poke2.optionalFunction);

console.log("=== Class ===")

class Pokemon implements IPokemon{
    name: string;
    level: number;
    health: number;
    damage?: number;

    //We have access modifiers back in typescript!
    public speed:number = 99;

    protected species:string = "Mouse";

    constructor() {
        this.name = "Pikachu";
        this.level = 10;
        this.health = 100;
        this.damage = 10
    }

    talk(): void {
        throw new Error("Method not implemented.");
    }
    optionalFunction?(): void {
        throw new Error("Method not implemented.");
    }

}

let poke3:Pokemon = new Pokemon();

console.log(poke3);
console.log(poke3.name);
console.log(poke3.speed);
// console.log(poke3.species); This is an error because species is protected

class Electric extends Pokemon {
    /**
     *
     */
    constructor() {
        super();
        // We have access to species since it is a protected access member
        this.species = "Electric";
    }
}