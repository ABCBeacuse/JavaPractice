package basic.thread;

public class Exercise {
    public static void main(String[] args) throws InterruptedException {
        Thread childThread = new Thread(new Child_02());

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " " + "hi" + i);
            if (i == 5) {
                childThread.start();
                try {
                    childThread.join();
                } catch (InterruptedException e) {
                }
            }
        }
        System.out.println("主线程结束");
    }
}

class Child_02 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + "hello" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("子线程退出");
    }
}

