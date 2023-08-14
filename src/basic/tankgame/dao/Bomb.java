package basic.tankgame.dao;

public class Bomb {

    public int x;

    public int y;

    // 炸弹生命，用于选择展示的 png
    public int life = 15;

    public boolean isAlive = true;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void decreaseLife() {
        if (life > 1) {
            life--;
        } else {
            isAlive = false;
        }
    }

}
