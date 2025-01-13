import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        double a = 2, b = 3;
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape rectangle = shapeFactory.makeShape(ShapeFactory.ShapeType.Rectangle, a, b);
        System.out.println("area of created rectangle is: " + rectangle.calcArea());
        Shape ellipse = shapeFactory.makeShape(ShapeFactory.ShapeType.Ellipse, a, b);
        System.out.println("area of ellipse is: " + ellipse.calcArea());
        Shape rhombus = shapeFactory.makeShape(ShapeFactory.ShapeType.Rhombus, a, b);
        System.out.println("area of rhombus is: " + rhombus.calcArea());

        System.out.println("random test...");
        List<Shape> array = new ArrayList<>();
        for(int i = 0; i < 5; i++)
            array.add(shapeFactory.randomNextShape());

        array.forEach((x) -> System.out.println(x.calcArea()));

    }
}
