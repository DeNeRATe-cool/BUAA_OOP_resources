public class Demo {
    public static void main(String[] args) {
        Child child=new Child();
        child.name="张三";
        // upcasting
        Parent parent=child;
        parent.name="李四";
        System.out.println("parent.name="+parent.name);
        System.out.println("child.name="+child.name);
        parent.eat();
        parent.sleep();
        child.eat();
        child.sleep();
        parent.study();
    }
}
class Parent{
    public String name;
    public void eat(){
        System.out.println("父类eating");
    }
    public static void sleep(){
        System.out.println("父类sleeping");
    }
    public void study() {
        System.out.println("父类studying");
    }
}
class Child extends Parent{
    public int age;
    public String name;
    @Override
    public void eat(){
        System.out.println("子类eating");
    }
    public static void sleep(){
        System.out.println("子类sleeping");
    }
    public void study(){
        System.out.println("子类studying");
    }
}