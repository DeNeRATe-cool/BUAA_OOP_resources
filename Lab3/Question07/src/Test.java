public class Test {
    public static void main(String[] args) {
        Motorbike motorbike = new Motorbike(2);
        Person brother = new Person("Brother");
        Person sister = new Person("Sister");

        motorbike.setDriver(brother);
        motorbike.setPassenger(sister);

        System.out.println(motorbike);
        sister.say("不像我，我只会心疼 giegie~");
    }
}
