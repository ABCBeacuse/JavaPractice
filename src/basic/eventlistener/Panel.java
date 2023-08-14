package basic.eventlistener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// 实现 KeyListener 监听器接口，添加键盘事件的监听
public class Panel extends JPanel implements KeyListener {

    private int x = 10;
    private int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);
    }

    // 当有字符输出时触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 当键盘按键按下时
    @Override
    public void keyPressed(KeyEvent e) {
        // 在 java 中，会给每一个键，分配一个值（int）
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            y--;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y++;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        }
        // 触发 paint 方法重绘，repaint() 是触发 paint 方法重绘的方式之一
        repaint();
    }

    // 当键盘按键弹起时
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
