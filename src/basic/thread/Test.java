package basic.thread;

public class Test {
    public static void main(String[] args) {
        // 开启 T1 线程
        T1 t1 = new T1();
        Thread thread = new Thread(t1);
        thread.start();

        // 开启 T2 线程
        T2 t2 = new T2();
        t2.start();

        /**
         * hello,world 1Thread-0
         * hi 1 Thread-1
         * hi 2 Thread-1
         * hello,world 2Thread-0
         * hi 3 Thread-1
         * hello,world 3Thread-0
         * hello,world 4Thread-0
         * hi 4 Thread-1
         * hi 5 Thread-1
         * hello,world 5Thread-0
         * hello,world 6Thread-0
         * hello,world 7Thread-0
         * hello,world 8Thread-0
         * hello,world 9Thread-0
         * hello,world 10Thread-0
         *
         * Process finished with exit code 0
         */
    }
}


// T1 通过实现 Runnable 接口 实现线程
class T1 implements Runnable {

    private int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("hello,world " + ++count + "" + Thread.currentThread().getName());
            if (count == 10) {
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

// T2 通过继承 Thread 类 来实现线程
class T2 extends Thread {

    private int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("hi " + ++count + " " + Thread.currentThread().getName());
            if (count == 5) {
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
