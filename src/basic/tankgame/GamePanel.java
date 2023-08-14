package basic.tankgame;

import basic.tankgame.dao.Bomb;
import basic.tankgame.dao.Bullet;
import basic.tankgame.dao.EnemyTank;
import basic.tankgame.dao.Hero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class GamePanel extends JPanel implements KeyListener, Runnable {
    private Hero mySelf;

    // 存放敌方坦克，使用 Vector（多线程）
    private Vector<EnemyTank> enemyTanks = new Vector<>();

    // 存放销毁坦克后，留下的 炸弹
    private Vector<Bomb> bombs = new Vector<>();

    // 敌方坦克默认数量为 3
    private int enemySize = 3;

    public GamePanel() {
        mySelf = new Hero(100, 100);
        mySelf.setSpeed(4);

        /**
         * 初始化敌方坦克
         */
        for (int i = 0; i < enemySize; i++) {
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            new Thread(enemyTank).start();
            // 炮口朝下
            enemyTank.setDirection(2);
            enemyTanks.add(enemyTank);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, 1000, 750);
        drawTank(mySelf.getX(), mySelf.getY(), g, 1, mySelf.getDirection());

        Vector<Bullet> bullets = mySelf.getBullets();
        // 绘制 myself 的炮弹
        for (int i = 0; i < bullets.size(); i++) {
            drawBullet(bullets.get(i), g, 1);
        }

        // 绘制敌方坦克（绘制存活的敌方坦克）
        for (EnemyTank tank : enemyTanks) {
            if (tank.isAlive()) {
                drawTank(tank.getX(), tank.getY(), g, 0, tank.getDirection());
            }
            // 敌方坦克死亡，其子弹也可能存活
            drawBullet(tank.getBullet(), g, 0);
        }

        // 绘制炸弹
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if (bomb.isAlive) {
                Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/爆炸" + (16 - bomb.life) + ".png"));
                g.drawImage(image, bomb.x, bomb.y, 60, 60, this);
                bomb.decreaseLife();
            } else {
                bombs.remove(bomb);
            }
        }
    }

    private void drawBullet(Bullet bullet, Graphics g, int type) {
        // 子弹不存活后，就不需要绘制了
        if (bullet == null || !bullet.isAlive) {
            // 并将子弹从集合中拿掉
            mySelf.removeBullet(bullet);
            return;
        }
        // 根据坦克类型来修改画笔颜色
        switch (type) {
            // 敌方坦克
            case 0:
                g.setColor(Color.cyan);
                break;
            // 我方坦克
            case 1:
                g.setColor(Color.orange);
                break;
        }
        g.fillRect(bullet.x, bullet.y, 3, 3);
    }

    // 绘制坦克
    public void drawTank(int x, int y, Graphics g, int type, int direction) {
        // 根据坦克类型来修改画笔颜色
        switch (type) {
            // 敌方坦克
            case 0:
                g.setColor(Color.cyan);
                break;
            // 我方坦克
            case 1:
                g.setColor(Color.orange);
                break;
        }
        // 坦克方向
        // 规定方向 0 - 向上，1 - 向右，2 - 向下， 3 - 向左
        switch (direction) {
            case 0:
                // 绘制坦克左边矩形
                g.fill3DRect(x, y, 10, 60, false);
                // 绘制坦克中间矩形
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                // 绘制坦克右边矩形
                g.fill3DRect(x + 30, y, 10, 60, false);
                // 绘制坦克中间圆形
                g.fillOval(x + 10, y + 20, 20, 20);
                // 绘制中间炮筒
                g.drawLine(x + 20, y, x + 20, y + 30);
                break;
            case 1:
                // 绘制坦克上边的矩形
                g.fill3DRect(x, y, 60, 10, false);
                // 绘制坦克中间的矩形
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                // 绘制坦克下边的矩形
                g.fill3DRect(x, y + 30, 60, 10, false);
                // 绘制坦克中间圆形
                g.fillOval(x + 20, y + 10, 20, 20);
                // 绘制中间炮筒
                g.drawLine(x + 60, y + 20, x + 30, y + 20);
                break;
            case 2:
                // 绘制坦克左边矩形
                g.fill3DRect(x, y, 10, 60, false);
                // 绘制坦克中间矩形
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                // 绘制坦克右边矩形
                g.fill3DRect(x + 30, y, 10, 60, false);
                // 绘制坦克中间圆形
                g.fillOval(x + 10, y + 20, 20, 20);
                // 绘制中间炮筒
                g.drawLine(x + 20, y + 60, x + 20, y + 30);
                break;
            case 3:
                // 绘制坦克上边的矩形
                g.fill3DRect(x, y, 60, 10, false);
                // 绘制坦克中间的矩形
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                // 绘制坦克下边的矩形
                g.fill3DRect(x, y + 30, 60, 10, false);
                // 绘制坦克中间圆形
                g.fillOval(x + 20, y + 10, 20, 20);
                // 绘制中间炮筒
                g.drawLine(x, y + 20, x + 30, y + 20);
                break;
        }
    }

    /**
     * 判断子弹是否击毁敌方坦克
     *
     * @param bullet
     * @param enemyTank
     */
    private void hitTank(Bullet bullet, EnemyTank enemyTank) {
        switch (enemyTank.getDirection()) {
            case 0:
            case 2:
                if (bullet.x > enemyTank.getX() && bullet.x < enemyTank.getX() + 40 && bullet.y > enemyTank.getY() && bullet.y < enemyTank.getY() + 60) {
                    // 提前结束子弹线程
                    bullet.isAlive = false;
                    // 这里只是不让绘画坦克了
                    enemyTank.setAlive(false);
                    // 除去已经击毁的坦克，防止 爆炸效果显示异常。
                    enemyTanks.remove(enemyTank);
                    bombs.add(new Bomb(enemyTank.getX(), enemyTank.getY()));
                }
                break;
            case 1:
            case 3:
                if (bullet.x > enemyTank.getX() && bullet.x < enemyTank.getX() + 60 && bullet.y > enemyTank.getY() && bullet.y < enemyTank.getY() + 40) {
                    bullet.isAlive = false;
                    enemyTank.setAlive(false);
                    enemyTanks.remove(enemyTank);
                    bombs.add(new Bomb(enemyTank.getX(), enemyTank.getY()));
                }
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            mySelf.setDirection(0);
            // 向上移动
            mySelf.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            mySelf.setDirection(2);
            // 向下移动
            mySelf.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            mySelf.setDirection(1);
            // 向右移动
            mySelf.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            mySelf.setDirection(3);
            // 向左移动
            mySelf.moveLeft();
        }

        if (e.getKeyCode() == KeyEvent.VK_J) {
            // J 键坦克射击
            mySelf.shotEnemy();
        }
        // 重绘
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    // 创建一个面板重绘线程，用于定时进行面板重绘
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // 查看自己的子弹是否还存活，然后遍历敌方坦克，查看是否被击毁。
            // 这里注意空指针异常，因为没有发射子弹时，bullet 是 null。
            Vector<Bullet> bullets = mySelf.getBullets();
            for (int i = 0; i < bullets.size(); i++) {
                Bullet bullet = bullets.get(i);
                if (bullet != null && bullet.isAlive) {
                    for (int j = 0; j < enemyTanks.size(); j++) {
                        hitTank(bullet, enemyTanks.get(j));
                    }
                }
            }
            repaint();
        }
    }
}
