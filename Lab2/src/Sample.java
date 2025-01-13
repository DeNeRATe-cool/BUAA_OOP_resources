public class Sample {
    int x;
    long y = x;

    public void f(int n) {
        int m = 1;
        int t = n + m;
        m = 20;
    }

    public static void main(String[] args) {
        Sample t = new Sample();
        t.f(5);
        System.out.println(t.x);
    }

}
