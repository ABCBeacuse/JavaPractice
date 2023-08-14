package basic.tankgame.dao;

import java.util.Vector;

public class Hero extends Tank {

    public Vector<Bullet> bullets = new Vector<>();

    public Hero(int x, int y) {
        super(x, y);
    }

    public void shotEnemy() {
        if (bullets.size() > 4) {
            return;
        }
        Bullet bullet = null;
        switch (getDirection()) {
            case 0:
                bullet = new Bullet(getX() + 20, getY(), 0);
                break;
            case 1:
                bullet = new Bullet(getX() + 60, getY() + 20, 1);
                break;
            case 2:
                bullet = new Bullet(getX() + 20, getY() + 60, 2);
                break;
            case 3:
                bullet = new Bullet(getX(), getY() + 20, 3);
                break;
        }
        bullets.add(bullet);
        new Thread(bullet).start();
    }

    public Vector<Bullet> getBullets() {
        return bullets;
    }

    public void removeBullet(Bullet bullet) {
        bullets.remove(bullet);
    }
}
