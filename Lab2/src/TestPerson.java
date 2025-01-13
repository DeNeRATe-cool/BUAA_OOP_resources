public class TestPerson {

    public static void main(String[] args) {
        Person person1 = new Person("yjyx", 20, "male");
        person1.setAge(18);
        System.out.println(person1.getAge());

        Person person2 = new Person("hjx", 18, "female");
        person2.setAge(20);
        System.out.println(person2.getAge());
    }
}

class Person {
    private String name;
    private int age;
    private String sex;

    Person() {}
    Person(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void setAge(int age) {
        assert age >= 0 && age <= 130;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void work() {
        System.out.println("working");
    }

    public void showAge() {
        System.out.println(this.age);
    }
}
