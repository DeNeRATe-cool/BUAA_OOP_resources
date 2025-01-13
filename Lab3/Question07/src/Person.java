public class Person {
    private String name;

    public Person() {}
    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void say(String words) {
        System.out.println(words);
    }
}
