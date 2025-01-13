public class ShapeFactory {
    enum ShapeType {
        Rectangle, Ellipse, Rhombus
    }

    public Shape makeShape(ShapeType shapeType, double a, double b) {
        if(a < 0 || b < 0) return null;
        switch (shapeType) {
            case Rectangle: return new Rectangle(a, b);
            case Ellipse: return new Ellipse(a, b);
            case Rhombus: return new Rhombus(a, b);
        };
        return null;
    }

    public Shape randomNextShape() {
        int opt = (int)(Math.random() * 99) % 3;
        double a = Math.random() * 100, b = Math.random() * 100;
        switch(opt) {
            case 0: return new Rectangle(a, b);
            case 1: return new Ellipse(a, b);
            case 2: return new Rhombus(a, b);
        }
        return null;
    }
}
