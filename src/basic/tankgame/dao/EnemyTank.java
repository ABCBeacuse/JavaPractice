package basic.tankgame.dao;

public class EnemyTank extends Tank implements Runnable {

    private Bullet bullet;

    private boolean isAlive = true;

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    public void shot() {
        if (!isAlive || bullet != null && bullet.isAlive) {
            return;
        }
        bullet = new Bullet(getX() + 20, getY() + 60, getDirection());
        new Thread(bullet).start();
    }

    @Override
    public void run() {
        while (isAlive) {
            // 每个方向让坦克走 40 步
            switch (getDirection()) {
                case 0:
                    for (int i = 0; i < 40; i++) {
                        moveUp();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 40; i++) {
                        moveRight();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 40; i++) {
                        moveDown();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 40; i++) {
                        moveLeft();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
            }
            // 随机转向 ( 0 - 3)
            setDirection((int) (Math.random() * 4));
            shot();
        }
    }

    public Bullet getBullet() {
        return bullet;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
