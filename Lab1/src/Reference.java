class Point {
    int x, y;

    void setXY(int m, int n) {
        x = m;
        y = n;
    }
}

public class Reference {
    public static void main(String[] args) {
        Point p1, p2;
        p1 = new Point();
        p2 = new Point();
        System.out.println("p1 的引用: " + p1);
        System.out.println("p2 的引用: " + p2);
        p1.setXY(1111, 2222);
        p2.setXY(-100, -200);
        System.out.println("p1 的 x, y 坐标: " + p1.x + ", " + p1.y); // 1
        System.out.println("p2 的 x, y 坐标: " + p2.x + ", " + p2.y); // 2
        p1 = p2;
        p1.setXY(0, 0);
        System.out.println("p1 的引用: " + p1);
        System.out.println("p2 的引用: " + p2);
        System.out.println("p1 的 x, y 坐标: " + p1.x + ", " + p1.y); // 3
        System.out.println("p2 的 x, y 坐标: " + p2.x + ", " + p2.y); // 4
    }
}