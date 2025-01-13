public class Tank extends Vehicle {
    private int seat;
    private String driver;

    public Tank() {}
    public Tank(int wheel) {
        super(wheel);
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
