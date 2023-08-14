package basic.tankgame.dao;

/**
 * 坦克主类
 */
public class Tank {
    private int x;
    private int y;
    private int direction; // 坦克方向 （int 默认值为 0）

    private int speed = 1; // 坦克速度

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveUp() {
        if (y <= 0) {
            return;
        }
        y -= speed;
    }

    public void moveDown() {
        if (y + 60 >= 750) {
            return;
        }
        y += speed;
    }

    public void moveLeft() {
        if (x <= 0) {
            return;
        }
        x -= speed;
    }

    public void moveRight() {
        if (x + 60 >= 1000) {
            return;
        }
        x += speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
