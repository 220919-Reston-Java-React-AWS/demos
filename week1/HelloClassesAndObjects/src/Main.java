public class Main {
    public static void main(String[] args) {
        Person pablo = new Person("Pablo", "Trainer");
//        pablo.name = "Pablo";
//        pablo.role = "Trainer";

        System.out.println(pablo.name);
        System.out.println(pablo);

        Person bach = new Person("Bach", "Lead Trainer");

        System.out.println(bach.name);
        System.out.println(bach);
        System.out.println(pablo.toString());
        System.out.println(pablo.equals(bach)); // false

        Adult mary = new Adult();
        mary.name = "Mary";
        mary.role = "Co Trainer";

        pablo.sayHello();
        mary.sayHello();
        System.out.println(mary.toString());

        int x = 0;
        if (++x < 1){
            //x is 1 so it does run
            System.out.println(x);
        }

        Singleton s = Singleton.getSingleton();
        System.out.println(s.x);
        Singleton s2 = Singleton.getSingleton();
        System.out.println(s2.x);
    }
}
