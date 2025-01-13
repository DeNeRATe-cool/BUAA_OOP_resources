class Singleton {
    private static final Singleton uniqueInstance = new Singleton();
    private Singleton() {
    }
    public static Singleton getInstance() {
        return uniqueInstance;
    }
    public void foo() {
        System.out.println("Aha!");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("main begins...");
        Singleton.getInstance().foo();
    }
}