public class Vehicle {
    protected Wheel wheel;
    protected Engine engine;

    public Vehicle() {}
    public Vehicle(int wheel) {
        this.wheel = new Wheel(wheel);
    }

    public void setWheel(int wheel) {
        this.wheel.setWheel(wheel);
    }
}

class Wheel {
    protected int wheel;

    public Wheel() {}
    public Wheel(int wheel) {
        this.wheel = wheel;
    }

    public void setWheel(int wheel) {
        this.wheel = wheel;
    }
}

class Engine {
    protected String name;

    public Engine() {}
    public Engine(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
}