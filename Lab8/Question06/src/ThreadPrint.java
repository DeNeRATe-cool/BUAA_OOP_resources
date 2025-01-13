public class ThreadPrint {
    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        MyThread threadA = new MyThread("A", c, a);
        MyThread threadB = new MyThread("B", a, b);
        MyThread threadC = new MyThread("C", b, c);
        new Thread(threadA).start();
//        Thread.sleep(100);
        new Thread(threadB).start();
//        Thread.sleep(100);
        new Thread(threadC).start();
//        Thread.sleep(100);
    }
}

class MyThread implements Runnable {
    private String name;
    private Object prev;
    private Object self;

    public MyThread(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count--;
                    // ===1===
                    self.notifyAll();
                }
                try {
                    if (count == 0) {
                        // ===2===
                        prev.notifyAll();
                    } else {
                        // ===3===
                        prev.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}