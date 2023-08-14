package basic.thread;

public class HomeWork3 {
    public static void main(String[] args) {
        Person_ person = new Person_();

        // 两个线程共享一个 对象数据 --- person
        Thread thread = new Thread(person);
        thread.setName("用户 1");
        Thread thread1 = new Thread(person);
        thread1.setName("用户 2");

        thread.start();
        thread1.start();
    }
}

// 因为存在共享数据的情况，使用 实现 Runnable 接口的方式比较方便。
class Person_ implements Runnable {

    private int money = 10000;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // 添加对象锁，对象锁是 非公平锁
            // 这里使用 synchronized 实现了线程同步
            // 当多个线程执行到这里时，就会去争夺 this 对象锁
            // 哪个线程争夺到 this 对象锁，就执行 synchronized 代码块
            // 争夺不到 this 对象锁，就 blocked，准备继续争夺
            synchronized (this) {
                if (money < 1000) {
                    System.out.println(threadName + "发现余额不足....");
                    break;
                }
                money -= 1000;
                System.out.println(threadName + "取出金额 1000，剩余 " + money);
            }
        }
        System.out.println(threadName + "退出....");
    }
}
