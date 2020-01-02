import greenfoot.*;

/**
 * Stars for main game screen. Our star field is going to provide
 * various sized stars moving in the background at various speeds,
 * to produce the effect of moving through space at high speed.
 * 
 * @author Michael Haungs
 * @author Jegors Čemisovs
 * @version 2020-01-01
 */
public class Star extends Actor {
    private int twinkleTime = 0;
    private int currentTransparency = 0;
    private int speed = 1;

    public Star() {
        // Instead of setting the image of the star to a file containing a graphic,
        // we are going to dynamically draw the image
        final GreenfootImage image = new GreenfootImage(10, 10);
        image.setColor(Color.WHITE);
        image.fillOval(0, 0, 10, 10);
        if (Greenfoot.getRandomNumber(1000) < 300) {
          // this is a close bright star
          speed = 3;
          image.setTransparency(Greenfoot.getRandomNumber(25) + 225);
          image.scale(4, 4);
        } else {
          // this is a further dim star
          speed = 2;
          image.setTransparency(Greenfoot.getRandomNumber(50) + 100);
          image.scale(2, 2);
        }
        setImage(image);
    }

    public void act() {
        setLocation(getX(), getY() + speed);
        checkRemove();
        checkTwinkle();
    }

    private void checkRemove() {
        final World world = getWorld();
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
