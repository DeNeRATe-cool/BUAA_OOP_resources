public class Rectangle extends Shape {
    Rectangle() {}
    Rectangle(double x, double y) {
        super(x, y);
    }
    @Override
    public double calcArea() {
        return a * b;
    }
}
