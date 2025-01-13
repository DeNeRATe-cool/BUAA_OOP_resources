import java.util.*;

public class WechatNoticeApplication {
    public static void main(String[] args) {
        SubscriptionSubject wechat = new SubscriptionSubject();
        wechat.attach(new WechatUser("people - A"));
        wechat.attach(new WechatUser("people - B"));
        wechat.attach(new WechatUser("people - C"));
        wechat.notify("感谢关注!");
    }
}

interface Subject {
    public void attach(Observer o);
    public void detach(Observer o);
    public void notify(String message);
}

class SubscriptionSubject implements Subject {
    private List<Observer> userList = new ArrayList<>();
    public void attach(Observer o) {
        userList.add(o);
    }
    public void detach(Observer o) {
        userList.remove(o);
    }
    public void notify(String message) {
        for(Observer o: userList) {
            o.update(message);
        }
    }
}

interface Observer {
    public void update(String message);
}

class WechatUser implements Observer {
    private String name;
    public WechatUser(String name) {this.name = name;}
    public void update(String message) {
        System.out.println(name + " - " + message);
    }
}
