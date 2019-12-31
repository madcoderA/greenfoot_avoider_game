/**
 * Implementation of avatar's eyes.
 * 
 * @author Jegors Čemisovs
 * @version 2019-12-31
 */
import java.util.List;
import greenfoot.*;

public class Eye extends Actor {
    public Eye() {
        drawEye(2, 2);
    }

    public void act() {
        lookAtEnemies();
    }

    private void drawEye(int dx, int dy) {
        final GreenfootImage eyeImage = new GreenfootImage(10, 10);
        eyeImage.setColor(Color.WHITE);
        eyeImage.fillOval(0, 0, 10, 10);
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
