public class Test {
    public static void main(String[] args) {
        double a = 2, b = 3;

        Rectangle rec = new Rectangle();
        rec.setA(a);
        rec.setB(b);
        System.out.println(rec.calcArea());

        Rhombus rho = new Rhombus();
        rho.setA(a);
        rho.setB(b);
        System.out.println(rho.calcArea());

        Ellipse ell = new Ellipse();
        ell.setA(a);
        ell.setB(b);
        System.out.println(ell.calcArea());

        System.out.println("test finished!");
    }
}
