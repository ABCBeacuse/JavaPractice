package basic.eventlistener;

import javax.swing.*;

public class EventListener extends JFrame {
    private Panel panel;

    public static void main(String[] args) {
        new EventListener();
    }

    public EventListener() {
        panel = new Panel();
        this.add(panel);
        this.setSize(400, 300);
        // 将 panel 添加到 frame 的事件监听中
        // 这里需要一个 KeyListener 类型的对象，因为 Panel 类实现了 KeyListener 接口，所以根据接口的多态，Panel 类型的对象可以被 KeyListener 的变量指向。
        this.addKeyListener(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
