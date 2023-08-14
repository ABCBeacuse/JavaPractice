package basic.tankgame;

import javax.swing.*;

public class GameFrame extends JFrame {

    private GamePanel panel;

    public static void main(String[] args) {
        new GameFrame();
    }

    public GameFrame() {
        panel = new GamePanel();

        // 启动一个线程，用来不断重新绘制 panel
        Thread reDrawThread = new Thread(panel);
        reDrawThread.start();
        this.add(panel);
        this.setSize(1200, 850);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        // JFrame 监听 JPanel
        this.addKeyListener(panel);
    }
}
