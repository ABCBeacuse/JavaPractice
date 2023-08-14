package basic.thread;

public class HomeWork2 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Person1");

        Person person1 = new Person();
        person1.setName("Person2");

        person.start();
        person1.start();
    }
}

class Person extends Thread {
    public static int money = 10000;

    public static Object locker = new Object();

    private boolean loop = true;

    private void takeOut() {
        // 保证 不同线程 使用的是 同一个对象锁
        synchronized (locker) {
            if (money < 1000) {
                System.out.println(Thread.currentThread().getName() + "发现余额不足...");
                // 执行 break 或者 return 时，当前线程会释放掉锁。
                loop = false;
                return;
            }
            money -= 1000;
            System.out.println(Thread.currentThread().getName() + "成功取出 1000 元" + "剩余" + money);
        }
    }

    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            takeOut();
        }
    }
}