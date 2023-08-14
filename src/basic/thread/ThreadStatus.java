package basic.thread;

public class ThreadStatus {
    public static void main(String[] args) throws InterruptedException {
        T_ t = new T_();
        System.out.println(t.getState());
        t.start();

        // t.getState() 获取 线程t 的运行状态
        while (Thread.State.TERMINATED != t.getState()) {
            System.out.println("子线程" + t.getName() + "状态 " + t.getState());
            Thread.sleep(1000);
        }

        System.out.println("最后的子线程状态" + t.getState());
    }
}

class T_ extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            System.out.println("子线程正在运行 " + i);
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
