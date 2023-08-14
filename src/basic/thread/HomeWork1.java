package basic.thread;

import java.util.Scanner;

public class HomeWork1 {
    public static void main(String[] args) {
        T3 t3 = new T3();
        new Thread(t3).start();

        new Thread(new T4(t3)).start();
    }
}

class T3 implements Runnable {

    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            // 随机输出 1-100 的整数
            System.out.println((int) (Math.random() * 100 + 1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}


class T4 implements Runnable {

    private T3 a;

    private Scanner scanner = new Scanner(System.in);

    public T4(T3 a) {
        this.a = a;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("请输入：(Q) 退出");
            char c = scanner.next().toUpperCase().charAt(0);
            if (c == 'Q') {
                a.setLoop(false); // 以通知方式结束线程 T3
                break;
            }
        }
        System.out.println("T4- " + Thread.currentThread().getName() + " 线程退出");
    }
}
