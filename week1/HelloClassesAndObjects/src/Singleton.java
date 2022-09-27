public class Singleton {
    private static Singleton single_instance = null;

    int x =0;
    private Singleton(){
        x = 1;
    }

    public static Singleton getSingleton(){
        if (single_instance == null)
            single_instance = new Singleton();

        return single_instance;    }
}
