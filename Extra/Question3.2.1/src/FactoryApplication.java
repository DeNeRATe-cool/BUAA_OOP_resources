public class FactoryApplication {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.createVehicle("car");
        car.drive();
    }
}

class VehicleFactory {
    public static Vehicle createVehicle(String type) {
        if(type.equalsIgnoreCase("Car")) {
            return new Car();
        } else if(type.equalsIgnoreCase("Truck")) {
            return new Truck();
        } else {
            throw new IllegalArgumentException("Unknown vehicle type!");
        }
    }

}

interface Vehicle {
    void drive();
}

class Car implements Vehicle {
    public void drive() {
        System.out.println("drive a car");
    }
}

class Truck implements Vehicle {
    public void drive() {
        System.out.println("drive a truck");
    }
}