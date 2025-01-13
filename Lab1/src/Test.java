import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Test {
    static List<PurchasingAgent> purchasingAgents = new ArrayList<>();
    static List<Chef> chefs = new ArrayList<>();

    private static void addPurchasingAgent(String... args) {
        for(String arg : args) {
            purchasingAgents.add(new PurchasingAgent(arg));
        }
    }

    private static void addChef(String... args) {
        for(String arg : args) {
            chefs.add(new Chef(arg));
        }
    }

    public static void main(String[] args) {
        addPurchasingAgent("姑姑", "妈妈", "我");
        addChef("爸爸", "婶婶");
    }

}

class PurchasingAgent {
    String name;
    List<String> stuff = new ArrayList<>();

    PurchasingAgent() {}

    PurchasingAgent(String name) {
        this.name = name;
    }

    private void buyStuff(String... args) {
        // buy stuffs
    }
}

 class Chef {
    String name;
    List<String> dish = new ArrayList<>();

    Chef() {}

    Chef(String name) {
        this.name = name;
    }
    private void cookDish(String... args) {
        // cook dishes in a queue
    }
 }
