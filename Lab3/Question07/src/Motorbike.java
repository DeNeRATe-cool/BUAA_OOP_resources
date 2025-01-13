public class Motorbike extends Vehicle {
    private String driver;
    private String passenger;

    public Motorbike() {}
    public Motorbike(int wheel) {
        super(wheel);
    }

    public void setDriver(Person driver) {
        this.driver = driver.getName();
    }

    public void setPassenger(Person passenger) {
        this.passenger = passenger.getName();
    }

    @Override
    public String toString() {
        return "It is a " + wheel.wheel + " wheels motorbike with a driver called " + driver + " and a passenger called " + passenger;
    }
}
