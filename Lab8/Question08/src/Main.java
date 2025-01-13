import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Producer producer = new Producer(lock);
        Consumer consumer = new Consumer(lock);

        new Thread(producer).start();
        Thread.sleep(100);
        new Thread(consumer).start();
    }
}

class Producer implements Runnable {
    private final Object lock;
    private boolean hasData = false;

    public Producer(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 10; i++) {
            synchronized (lock) {
                while(hasData) {
                    try {
                        lock.wait();
                        hasData = false;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("now let's produce...");
                hasData = true;
                lock.notify();
            }
        }
    }
}

class Consumer implements Runnable {
    private final Object lock;
    private boolean hasData = true;

    public Consumer(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 10; i++) {
            synchronized (lock) {
                while(!hasData) {
                    try {
                        lock.wait();
                        hasData = true;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("now let's consume...");
                hasData = false;
                lock.notify();
            }
        }
    }
}