class A {
    int number;
    A() {}
    A(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
}

class B extends A {
    B(int number) {
        super(number);
    }
    public int getNumber() {
        return super.number;
    }
    public void setNumber(int number) {
        super.number = number;
    }
}

class C extends A {
    C(int number) {
        super(number);
    }
    public int getNumber() {
        return super.number;
    }
    public void setNumber(int number) {
        super.number = number;
    }
}

public class Pair<T1, T2> {
    T1 first;
    T2 second;
    public Pair() {}
    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public void setFirst(T1 first) {
        this.first = first;
    }

    public T2 getSecond() {
        return second;
    }

    public void setSecond(T2 second) {
        this.second = second;
    }

    public void swap() {
        if(first.getClass().getSuperclass() == second.getClass() ||
                first.getClass() == second.getClass().getSuperclass() ||
                first.getClass() == second.getClass() ||
                first.getClass().getSuperclass() == second.getClass().getSuperclass()) {
            T2 temp = second;
            second = (T2)first;
            first = (T1)temp;
        }
    }

    public static void main(String[] args) {
        B b = new B(1);
        C c = new C(2);
        Pair<A, A> p = new Pair<>(b, c);

        System.out.println(p.getFirst().getNumber() + " " + p.getSecond().getNumber());
        p.swap();
        System.out.println(p.getFirst().getNumber() + " " + p.getSecond().getNumber());
    }
}