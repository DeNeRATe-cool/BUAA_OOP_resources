import static java.lang.Math.PI;

public class Ellipse extends Shape {
    Ellipse() {}
    Ellipse(double x, double y) {
        super(x, y);
    }
    @Override
    public double calcArea() {
        return PI * a * b;
    }
}
