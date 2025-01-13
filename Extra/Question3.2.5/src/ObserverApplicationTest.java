import java.util.*;

public class ObserverApplicationTest {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();
        publisher.add(new Subscriber("userA"));
        publisher.add(new Subscriber("userB"));
        publisher.add(new Subscriber("uesrC"));

        publisher.notify("更新啦更新啦！");
    }
}

abstract class Observer {
    public String name;
    public Observer(String name) {this.name = name;}
    abstract void update(String message);
}

class Subscriber extends Observer {
    Subscriber(String name) {super(name);}
    public void update(String message) {
        System.out.println(name + " received news: " + message);
    }
}

class Publisher {
    private List<Observer> userList = new ArrayList<>();
    public void add(Observer observer) {
        userList.add(observer);
    }
    public void remove(Observer observer) {
        userList.remove(observer);
    }
    public void notify(String message) {
        for(Observer observer: userList) {
            observer.update(message);
        }
    }
}