import java.util.List;
import java.util.ArrayList;

public class Car extends Vehicle {
    List<String> passengers = new ArrayList<>();
    private String driver;
    private int seat;

    public Car() {}
    public Car(int wheel) {
        super(wheel);
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void addPassengers(String passenger) {
        passengers.add(passenger);
    }
}
