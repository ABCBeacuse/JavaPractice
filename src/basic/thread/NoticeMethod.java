package basic.thread;

public class NoticeMethod {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();

        // 主线程休眠 10s
        Thread.sleep(10 * 1000);

        // 如果希望 main 线程去控制 t 线程的中止，必须可以修改 loop
        // 让 t1 退出 run 方法，从而终止 t1 线程 -> 通知方式
        t.setLoop(false);
    }
}


class T extends Thread {

    private int count = 0;

    // 设置一个控制变量
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("T 运行中" + Thread.currentThread().getName() + " " + ++count);
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}