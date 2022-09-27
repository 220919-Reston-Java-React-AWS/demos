public class Adult extends Person {
    //Overriding
    String name;

    //override method
    public void sayHello(){
        System.out.println("Override sayHello method");
    }

    @Override
    public String toString() {
        return "Adult{" +
                "name='" + name + '\'' +
                '}';
    }
}
