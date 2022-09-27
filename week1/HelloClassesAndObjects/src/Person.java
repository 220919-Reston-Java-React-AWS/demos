public class Person {
    //fields or properties
    String name;
    String role;

    //Constructor
    Person(String name, String role){
        this.name = name;
        this.role = role;
    }
    //overloading
    Person(){
        super();
    }
    public void sayHello(){
        System.out.println(name + " Says Hello");
    }
}
