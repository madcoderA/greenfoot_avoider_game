import java.util.*;
import greenfoot.*;

public class Avatar extends Actor
{
    private int hitDelay = 50;
    private int nextImage = 0;
    private int health = 3;
    private int stunDelay = 0;
    private int lagDelay = 0;
    private Eye leftEye;
    private Eye rightEye;

    public void followMouse()
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (mi != null) {
            if (lagDelay > 0) {
                --lagDelay;
                setLocation((getX() + mi.getX())/2, (getY()+mi.getY())/2);
            } else setLocation(mi.getX(), mi.getY());
            leftEye.setLocation(getX() - 10, getY() - 8);
            rightEye.setLocation(getX() + 10, getY() - 8);
        }
    }

    /**
     * Act - do whatever the Avatar wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (stunDelay > 0) --stunDelay;
        else followMouse();
        checkForCollisions();
    }

    public void checkForCollisions()
    {
        Actor enemy = getOneIntersectingObject(Enemy.class);
        if (hitDelay == 0 && enemy != null) {
            if (health == 0) {
                AvoiderWorld world = (AvoiderWorld)getWorld();
                world.endGame();
            }
            else {
                --health;
                ++nextImage;
                setImage("skull" + nextImage + ".png");
                hitDelay = 50;
            }
        }
        if (hitDelay > 0) {
            --hitDelay;
            if (hitDelay % 10 == 0) getImage().setTransparency(255);
            else if (hitDelay % 10 == 5) getImage().setTransparency(100);
        }
    }

    protected void addedToWorld(World w)
    {
        leftEye =  new Eye();
        rightEye =  new Eye();
        w.addObject(leftEye, getX() - 10, getY() - 8);
        w.addObject(rightEye, getX() + 10, getY() - 8);
    }

    public void lagControls()
    {
        lagDelay += 150;
    }

    public void addHealth()
    {
        if (health < 3) {
            ++health;
            --nextImage;
            if (nextImage == 0) {
                setImage("skull.png");
            }
            else {
                setImage("skull" + nextImage + ".png");
            }
        }
    }

    public void stun()
    {
        stunDelay += 50;
    }
}
