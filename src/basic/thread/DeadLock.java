package basic.thread;

public class DeadLock {
    public static void main(String[] args) {
        // 创建 flag 不同的两个线程
        DeadThread thread = new DeadThread(true);
        thread.setName("A 线程");
        DeadThread thread1 = new DeadThread(false);
        thread1.setName("B 线程");

        thread.start();
        thread1.start();
    }
}

class DeadThread extends Thread {

    public static final Object o1 = new Object();

    public static final Object o2 = new Object();

    private boolean flag;

    public DeadThread(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + " 进入 1, 手里拿着 o1 锁，等待 o2 锁");
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + " 进入 2, 手里拿着 o1 和 o2 锁");
                }
            }
        } else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + " 进入 3, 手里拿着 o2 锁，等待 o1 锁");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + " 进入 4, 手里拿着 o1 和 o2 锁");
                }
            }
        }
    }
}
