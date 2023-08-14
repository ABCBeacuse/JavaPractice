package basic.draw;

import javax.swing.*;
import java.awt.*;

// 需要继承 JFrame，即 画布外面的框
public class DrawCircle extends JFrame {

    // 定义一个面板
    private MyPanel mp = null;

    public static void main(String[] args) {
        new DrawCircle();
    }

    // 构造器
    DrawCircle() {
        // 初始化面板
        mp = new MyPanel();
        // 把面板放到窗口（画框）
        this.add(mp);
        // 设置窗口的大小（外框大小）
        this.setSize(512, 768);
        // 设置为可以显示
        this.setVisible(true);
        // 当点击窗口的小×，程序完全退出（如果没有这个，点击 × 后 JVM 不会释放这个程序）
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

// MyPanel 类继承 JPanel 类， 画图形，就在面板上面
class MyPanel extends JPanel {

    /**
     * paint() 方法被调用的时机
     * 1. 当组件第一次在屏幕显示的时候，程序会自动调用 paint()方法来绘制组件
     * 2. 窗口最小化，再最大化，会再次调用
     * 3. 窗口的大小发生变化
     * 4. repaint 函数被调用
     */
    @Override
    public void paint(Graphics g) {
        // g 可以看做是 画笔，Graphics 提供了很多绘制方法
        // 调用父类的方法完成初始化
        super.paint(g);
        // 画一个圆
        // g.drawOval(30, 30, 40, 40);

        // 画直线
        // g.drawLine(10, 10, 100, 100);

        // 画矩形边框
        // g.drawRect(10, 10, 100, 100);

        // 填充矩形
        // 设置画笔颜色
        // g.setColor(Color.cyan);
        // g.fillRect(20, 20, 100, 100);

        // 填充椭圆
        // g.fillOval(200, 200, 30, 30);

        // 画图片
        // 1. 获取图片资源, /640.jpg 表示在项目的根目录去获取 640.jpg 图片资源（图片需要放在 out 文件夹下，项目根目录）
        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/640.jpg"));
        g.drawImage(image, 0, 0, 512, 768, this);

        // 画字符串
        g.setColor(Color.BLUE);
        g.setFont(new Font("隶书", Font.BOLD, 20));
        g.drawString("String", 20, 20);
    }
}