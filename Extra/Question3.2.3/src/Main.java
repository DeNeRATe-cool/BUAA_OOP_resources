public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        lightOn.execute();
        lightOff.execute();
    }
}

interface Command {
    void execute();
}

class Light {
    public void on() {
        System.out.println("light on");
    }
    public void off() {
        System.out.println("light off");
    }
}

class LightOnCommand implements Command {
    private Light light;
    public LightOnCommand(Light light) {this.light = light;}
    public void execute() {
        light.on();
    }
}

class LightOffCommand implements Command {
    private Light light;
    public LightOffCommand(Light light) {this.light = light;}
    public void execute() {
        light.off();
    }
}