import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = Arrays.asList(new Circle(), new Rectangle(), new Triangle());
        new DrawTool().drawShapes(shapes);
    }
}

abstract class Shape {
    abstract void draw();
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("draw a circle");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("draw a rectangle");
    }
}

class DrawTool {
    void drawShapes(List<Shape> shapes) {
        for(Shape s: shapes) {
            s.draw();
        }
    }
}

// 可扩展部分
class Triangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a Triangle");
    }
}