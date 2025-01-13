import java.math.BigDecimal;

public class Box<T extends Number> {
    private T number;

    public Box(T number) {
        this.number = number;
    }

    public T getNumber() {
        return number;
    }

    public static Number compareBoxes(Box<? extends Number> b1, Box<? extends Number> b2) {
        BigDecimal a = new BigDecimal(b1.getNumber().toString());
        BigDecimal b = new BigDecimal(b2.getNumber().toString());
//        System.out.println(a);
//        System.out.println(b);
        return a.compareTo(b) > 0 ? a : b;
    }

    public static void main(String[] args) {
        Box<Integer> box1 = new Box<>(42);
        Box<Double> box2 = new Box<>(42.5);

        System.out.println(Box.compareBoxes(box1, box2));
    }
}