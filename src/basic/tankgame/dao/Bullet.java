package basic.tankgame.dao;

public class Bullet implements Runnable {

    public int x;

    public int y;

    public int direction;

    private int speed = 2;

    public boolean isAlive = true;

    public Bullet(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public void run() {
        // 规定方向 0 - 向上，1 - 向右，2 - 向下， 3 - 向左
        while (true) {
            switch (direction) {
                case 0:
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }
            // 限制子弹存活范围
            // 当子弹碰到敌人坦克后，isAlive 变为 false 后，该子弹线程也会结束。
            if (x <= 0 || x >= 1000 || y <= 0 || y >= 750 || !isAlive) {
                isAlive = false;
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
