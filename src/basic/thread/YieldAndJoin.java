package basic.thread;

public class YieldAndJoin {
    public static void main(String[] args) throws InterruptedException {
        Child child = new Child();

        // 开启 child 子线程
        child.start();
        Thread.yield();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " 输出 " + i);
            Thread.sleep(1000);
            if (i == 4) {
                // 当主线程输出 5 次后， child 子线程插队，让子线程 child 全部执行完毕。
                child.join();
                System.out.println("子线程" + child.getName() + " 运行结束");
                System.out.println("主线程继续执行 ~");
            }
        }
    }
}

class Child extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " 输出 hello " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("子线程提前被 interrupt");
            }
        }
    }
}
