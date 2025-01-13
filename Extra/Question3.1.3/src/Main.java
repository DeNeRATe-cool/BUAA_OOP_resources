public class Main {
    public static void main(String[] args) {
        PayTool payTool = new PayTool();
        payTool.setPay(new AliPay());
        payTool.pay(999);
    }
}

interface Payment {
    void pay(int amount);
}

class AliPay implements Payment {
    public void pay(int amount) {
        System.out.println("paid using Alipay");
    }
}

class WechatPay implements Payment {
    public void pay(int amount) {
        System.out.println("paid using wechat");
    }
}

class PayTool {
    private Payment payment;
    public void setPay(Payment payment) {
        this.payment = payment;
    }
    public void pay(int amount) {
        this.payment.pay(amount);
    }
}
