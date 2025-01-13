public class DecoratorApplicationTest {
    public static void main(String[] args) {
        Coffee coffee = new OriginCoffee();
        System.out.println(coffee.getDescription());
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription());
        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription());
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription());
    }
}

abstract class Coffee {
    abstract double cost();
    abstract String getDescription();
}

class OriginCoffee extends Coffee {
    public double cost() {
        return 2.0;
    }
    public String getDescription() {
        return "A cup of coffee ";
    }
}

abstract class Decorator extends Coffee {
    Coffee coffee;
    public Decorator(Coffee coffee) {this.coffee = coffee;}
    abstract public double extraCost();
}

class MilkDecorator extends Decorator {
    private double extra = 1.0;
    public MilkDecorator(Coffee coffee) {super(coffee);}
    public double cost() {
        return coffee.cost() + extraCost();
    }
    public String getDescription() {
        return coffee.getDescription() + "with milk ";
    }
    public double extraCost() {
        return extra;
    }
}

class SugarDecorator extends Decorator {
    private double extra = 2.0;
    public SugarDecorator(Coffee coffee) {super(coffee);}
    public double cost() {
        return coffee.cost() + extraCost();
    }
    public String getDescription() {
        return coffee.getDescription() + "with sugar ";
    }
    public double extraCost() {
        return extra;
    }
}