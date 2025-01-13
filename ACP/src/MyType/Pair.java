package MyType;

public class Pair {
    private int l, r;

    public Pair(int l, int r) {
        this.l = l;
        this.r = r;
    }

    public void setL(int l) { this.l = l; }
    public void setR(int r) { this.r = r; }

    public int first() { return l; }
    public int second() { return r; }
}
