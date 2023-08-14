package basic.thread;

public class ThreadMethods {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.setName("小狗");
        myThread.setPriority(Thread.MIN_PRIORITY);

        // 启动线程
        myThread.start();

        // 输出 5 个 hi 后，提前中断 myThread 的休眠
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hi " + i);
        }

        System.out.println(myThread.getName() + " 的优先级是 " + myThread.getPriority());

        myThread.interrupt();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "吃包子" + i);
            }
            // 休眠 20s
            try {
                System.out.println(Thread.currentThread().getName() + " 休眠中...");
                Thread.sleep(20 * 1000);
                // 下面这个 InterruptedException 是用来捕捉在 线程睡眠时，其他线程发来了 Thread.interrupt 中断，即唤醒睡眠线程。
            } catch (InterruptedException e) {
                // 当该线程执行到一个 interrupt 方法时，就会产生一个异常
                // 可以写一些唤醒线程之后的业务代码
                // InterruptedException 捕捉到一个中断异常
                System.out.println(Thread.currentThread().getName() + "被 interrupt 了");
            }
        }
    }
}
