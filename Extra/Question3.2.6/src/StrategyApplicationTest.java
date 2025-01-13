public class StrategyApplicationTest {
    public static void main(String[] args) {
        Context sortAlgorithm = new Context();
        sortAlgorithm.setStrategy(new BubbleSort());
        sortAlgorithm.sort(new int[]{3, 2, 1});
        sortAlgorithm.setStrategy(new QuickSort());
        sortAlgorithm.sort(new int[]{6, 5, 4});
    }
}

interface Strategy {
    void sort(int[] arr);
}

class BubbleSort implements Strategy {
    public void sort(int[] arr) {
        System.out.println("sort using bubble sort...");
    }
}

class QuickSort implements Strategy {
    public void sort(int[] arr) {
        System.out.println("sort using quick sort...");
    }
}

class Context {
    private Strategy strategy;
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    public void sort(int[] arr) {
        strategy.sort(arr);
    }
}