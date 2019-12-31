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

    /**
     * Act - do whatever the Eye wants to do. This method is called whenever the
     * 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        lookAtEnemies();
    }

    private void drawEye(int dx, int dy) {
        GreenfootImage eyeImage = new GreenfootImage(10, 10);
        eyeImage.setColor(Color.WHITE);
        eyeImage.fillOval(0, 0, 10, 10);
        eyeImage.setColor(Color.BLACK);
        eyeImage.fillOval(dx, dy, 6, 6);
        setImage(eyeImage);
    }

    public void lookAtEnemies() {
        List<Enemy> enemies = getObjectsInRange(120, Enemy.class);
        if (enemies.isEmpty())
            return;

        Enemy enemy = enemies.get(0);
        if (enemy.getX() < getX()) {
            if (enemy.getY() < getY()) {
                drawEye(1, 1);
            } else {
                drawEye(1, 3);
            }
        } else {
            if (enemy.getY() < getY()) {
                drawEye(3, 1);
            } else {
                drawEye(3, 3);
            }
        }
    }

}
