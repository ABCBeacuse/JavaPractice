package basic.thread;

/**
 * 将一个子线程设置为 守护线程
 */
public class DaemonConfig {
    public static void main(String[] args) throws InterruptedException {
        DaemonThread daemonThread = new DaemonThread();

        // 希望 main 线程结束后，子线程自动结束，只需要将 daemonThread 子线程 设置为守护线程
        daemonThread.setDaemon(true);
        daemonThread.start();

        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("主线程(用户线程)正在工作...");
        }
        System.out.println("主线程运行结束...");
    }
}

class DaemonThread extends Thread {
    @Override
    public void run() {
        for (; ; ) { // 等同于 while(true)
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("守护线程正在工作...");
        }
    }
}
