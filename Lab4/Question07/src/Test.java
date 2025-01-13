interface Inter {
    void show();
}

class Outer {
    public static Inter method() {
        return new Inter() {
            @Override
            public void show() {
                System.out.println("DuluDulu");
            }
        };
    }
}

public class Test {
    public static void main(String[] args) {
        Outer.method().show();
    }
}