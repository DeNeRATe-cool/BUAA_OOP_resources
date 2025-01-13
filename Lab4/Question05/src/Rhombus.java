public class Rhombus extends Shape {
    Rhombus() {}
    Rhombus(double x, double y) {
        super(x, y);
    }
    @Override
    public double calcArea() {
        return a * b * 0.5;
    }
}
