public class PrintNumberAndLetter {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1 = new Thread(new NumberPrint(lock));
        Thread t2 = new Thread(new LetterPrint(lock));

        t1.start();
        t2.start();
    }
}

class NumberPrint implements Runnable {
    private final Object lock;
    private static int number = 1;

    public NumberPrint(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized(lock) {
            for(int i = 0; i < 26; i++) {
                System.out.print(number++);
                System.out.print(number++);
                lock.notifyAll();
                try {
                    if(i < 25) lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class LetterPrint implements Runnable {
    private final Object lock;
    private static char letter = 'A';

    public LetterPrint(Object lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        synchronized(lock) {
            for(int i = 0; i < 26; i++) {
                System.out.print(letter++);
                System.out.print(" ");
                lock.notifyAll();
                try {
                    if(i < 25) lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}