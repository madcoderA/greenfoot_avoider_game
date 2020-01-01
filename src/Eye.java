import java.util.List;
import greenfoot.*;

/**
 * Implementation of avatar's eyes.
 * 
 * @author Jegors Čemisovs
 * @version 2020-01-01
 */

public class Eye extends Actor {
    final static int SIZE = 10;

    public Eye() {
        drawEye(2, 2);
    }

    public void act() {
        lookAtEnemies();
    }

    private void drawEye(int dx, int dy) {
        final GreenfootImage eyeImage = new GreenfootImage(SIZE, SIZE);
        eyeImage.setColor(Color.WHITE);
        eyeImage.fillOval(0, 0, SIZE, SIZE);
        eyeImage.setColor(Color.BLACK);
        eyeImage.fillOval(dx, dy, 6, 6);
        setImage(eyeImage);
    }

    public void lookAtEnemies() {
        final List<Enemy> enemies = getObjectsInRange(120, Enemy.class);
        if (enemies.isEmpty()) {
            drawEye(2, 2);
        } else {
            final Enemy enemy = enemies.get(0);
            final int dx = enemy.getX() < getX() ? 1 : 3;
            final int dy = enemy.getY() < getY() ? 1 : 3;
            drawEye(dx, dy);
        }
    }
}
