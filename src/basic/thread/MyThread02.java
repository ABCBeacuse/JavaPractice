package basic.thread;

public class MyThread02 {

    public static void main(String[] args) {
        Dog dog = new Dog();
        // dog.start(); 通过接口 Runnable 方式实现的线程类，没有 start 方法来启动线程。

        // 创建了 Thread 对象，把 dog 对象（实现 Runnable），放入 Thread
        // 静态代理模式，相当于我没有 start 方法，但是你有，我借用一下。实际上真正干活的还是我自己。
        // Thread thread = new Thread(dog);
        // thread.start();

        // 使用模拟 Thread 类（ThreadProxy）
        Tiger tiger = new Tiger();
        ThreadProxy threadProxy = new ThreadProxy(tiger);
        threadProxy.start();
        // 老虎嗷嗷叫
    }
}

// 实现 Runnable 接口，开发线程
class Dog implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("小狗汪汪叫 " + ++count + Thread.currentThread().getName());
            if (count == 8) {
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

class Animal {}
class Tiger extends Animal implements Runnable {

    @Override
    public void run() {
        System.out.println("老虎嗷嗷叫");
    }
}


// 实现一个极简的 Thread 类的模拟
class ThreadProxy implements Runnable {

    private Runnable target = null;

    @Override
    public void run() {
        if (target != null) {
            target.run();  // 实现了 Runnable 接口的实体类对象 target，会查看当前 target 的运行类型，根据运行类型去执行 run() 方法。
        }
    }

    public ThreadProxy(Runnable target) {
        this.target = target; // 动态绑定
    }

    // 真正的 Thread 会先调用 start 方法
    public void start() {
        // 真正的 start0() 是一个 native 本地方法，由 JVM 调用，真正实现多线程，并调用 run 方法
        start0();
    }

    // Run 方法是由 start0 本地方法调用的。
    private void start0() {
        run();
    }
}