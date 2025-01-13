class StaticSuper {
    public static String staticGet() {
        return "Base staticGet()";
    }

    public String dynamicGet() {
        return "Base dynamicGet()";
    }
}

class StaticSub extends StaticSuper {
    public static String staticGet() {
        return "Derived staticGet()";
    }

    public String dynamicGet() {
        return "Derived dynamicGet()";
    }
}

public class Test {
    public static void main(String[] args) {
        StaticSuper sup = new StaticSub(); // upcasting
        System.out.println(StaticSuper.staticGet());
        System.out.println(sup.dynamicGet());
    }
}