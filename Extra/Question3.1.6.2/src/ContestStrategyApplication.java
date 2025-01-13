public class ContestStrategyApplication {
    public static void main(String[] args) {
        ContestStrategy game = new ContestStrategy();
        game.setStrategy(new StrategyA());
        System.out.println(game.getAverage(null));
        game.setStrategy(new StrategyB());
        System.out.println(game.getAverage(null));
    }
}

class ContestStrategy {
    Strategy strategy;
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    public double getAverage(double[] a) {
        return strategy.computerAverage(a);
    }
}

interface Strategy {
    double computerAverage(double[] a);
}

class StrategyA implements Strategy {
    public double computerAverage(double[] a) {
        return 0.0;
    }
}

class StrategyB implements Strategy {
    public double computerAverage(double[] a) {
        return 1.0;
    }
}

