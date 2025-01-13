public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

class Engine {
    void start() {
        System.out.println("Engine starts...");
    }
}

// 遵循迪米特原则
class Car {
    private Engine engine = new Engine();
    void start() {
        engine.start();
    }
    public Engine getEngine() {
        return engine;
    }
}

// 违反迪米特原则
class Driver {
    void start(Car car) {
        car.getEngine().start();
    }
}