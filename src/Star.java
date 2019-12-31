/**
 * Stars for main game screen.
 * 
 * @author Jegors Čemisovs
 * @version 2019-12-31
 */
import greenfoot.*;

public class Star extends Actor {
    protected int twinkleTime = 0;
    protected int currentTransparency = 0;
    int speed = 1;

    public Star() {
        final GreenfootImage image = new GreenfootImage(10, 10);
        image.setColor(Color.WHITE);
        image.fillOval(0, 0, 10, 10);
        setImage(image);
    }

    public void act() {
        setLocation(getX(), getY() + speed);
        checkRemove();
        checkTwinkle();
    }

    private void checkRemove() {
        World world = getWorld();
        if (getY() > world.getHeight() + 30) {
            world.removeObject(this);
        }
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    private void checkTwinkle() {
        final GreenfootImage image = getImage();
        if (twinkleTime > 0) {
            if (twinkleTime == 1) {
                image.setTransparency(currentTransparency);
            }
            twinkleTime = twinkleTime - 1;
        } else {
            if (Greenfoot.getRandomNumber(10000) < 10) {
                twinkleTime = 10;
                currentTransparency = image.getTransparency();
                image.setTransparency(0);
            }
        }
    }
}
