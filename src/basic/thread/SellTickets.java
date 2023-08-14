package basic.thread;

public class SellTickets {
    public static void main(String[] args) {
//        SellWindow window = new SellWindow();
//        SellWindow window1 = new SellWindow();
//        SellWindow window2 = new SellWindow();
//
//        window.start();
//        window1.start();
//        window2.start();

        /**
         * @ 会出现超卖的情况
         *
         * 窗口 Thread-2售出了一张票
         * 窗口 Thread-1售出了一张票
         * 当前剩余票数: -1
         * 窗口 Thread-0售出了一张票
         * 当前剩余票数: 0
         * 当前剩余票数: -2
         * 窗口 Thread-0已售空
         * 窗口 Thread-2已售空
         * 窗口 Thread-1已售空
         */

        // 通过实现 Runnable 接口的方式来实现多线程
//        SellWindow2 window2 = new SellWindow2();
//        // 创建了多个线程，这些线程共享 window2 对象
//        Thread thread = new Thread(window2);
//        Thread thread1 = new Thread(window2);
//        Thread thread2 = new Thread(window2);
//
//        thread.start();
//        thread1.start();
//        thread2.start();

        /**
         * @ 同样会出现超卖的情况
         *
         * 窗口 Thread-1售出了一张票
         * 当前剩余票数: 0
         * 窗口 Thread-0售出了一张票
         * 窗口 Thread-2售出了一张票
         * 当前剩余票数: -1
         * 当前剩余票数: -2
         */

        SellWindow3 window3 = new SellWindow3();
        // 开启三个线程（三个线程 共享一个对象）
        new Thread(window3).start();
        new Thread(window3).start();
        new Thread(window3).start();
    }
}

// 售票窗口
class SellWindow extends Thread {

    public static int ticketNum = 100;

    public void m() {
        synchronized (this) {
            System.out.println("这里看着加锁了，实际上没有加锁，因为每个线程的 this 都不一样");
        }
    }

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("窗口 " + Thread.currentThread().getName() + "已售空");
                break;
            }
            System.out.println("窗口 " + Thread.currentThread().getName() + "售出了一张票");
            System.out.println("当前剩余票数: " + --ticketNum);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class SellWindow2 implements Runnable {

    private int ticketNum = 100;

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("窗口 " + Thread.currentThread().getName() + "已售空");
                break;
            }
            System.out.println("窗口 " + Thread.currentThread().getName() + "售出了一张票");
            System.out.println("当前剩余票数: " + --ticketNum);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class SellWindow3 implements Runnable {

    private boolean loop = true;

    private int ticketNum = 100;

    private Object obj = new Object();

    // 线程同步（同一时间只允许一个线程访问）
    // 这里 synchronized 标志的是非静态的方法，所以 synchronized 绑定的是 this 对象。使用 this 对象中的一个位来表示锁是否存在。
    // 等同于 synchronized(this) { }
    public synchronized void m() {
        if (ticketNum <= 0) {
            System.out.println("窗口 " + Thread.currentThread().getName() + "已售空");
            loop = false;
            return;
        }
        System.out.println("窗口 " + Thread.currentThread().getName() + "售出了一张票");
        System.out.println("当前剩余票数: " + --ticketNum);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // 等价于 m() 方法
    public void e() {
        synchronized (this) {
            if (ticketNum <= 0) {
                System.out.println("窗口 " + Thread.currentThread().getName() + "已售空");
                loop = false;
                return;
            }
            System.out.println("窗口 " + Thread.currentThread().getName() + "售出了一张票");
            System.out.println("当前剩余票数: " + --ticketNum);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // 因为 f 是非静态方法，所以可以将 synchronized 绑定到 obj 这个对象上
    public void f() {
        // 需要保证所有线程访问的是同一个 obj。
        // 因为是以实现 Runnable 接口的方式，所以可以创建多个线程，共享一个对象。
        synchronized (obj) {
            if (ticketNum <= 0) {
                System.out.println("窗口 " + Thread.currentThread().getName() + "已售空");
                loop = false;
                return;
            }
            System.out.println("窗口 " + Thread.currentThread().getName() + "售出了一张票");
            System.out.println("当前剩余票数: " + --ticketNum);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // 同步方法（静态的）的锁为当前类本身
    // public synchronized static void g() { } 锁是加在 当前类上 SellWindow3.class
    public synchronized static void g() {

    }

    // 如果在静态方法，实现一个同步代码块
    public static void h() {
        synchronized (SellWindow3.class) {

        }
    }

    @Override
    public void run() {
        while (loop) {
            m();
        }
    }
}
