// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Avatar extends Actor
{
    private int hitDelay = 50;
    private int nextImage = 0;
    private int health = 3;
    private Eye leftEye;
    private Eye rightEye;

    /**
     * 
     */
    public void followMouse()
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (mi != null) {
            setLocation(mi.getX(), mi.getY());
            leftEye.setLocation(getX() - 10, getY() - 8);
            rightEye.setLocation(getX() + 10, getY() - 8);
        }
    }

    /**
     * Act - do whatever the Avatar wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        followMouse();
        checkForCollisions();
    }

    /**
     * 
     */
    public void checkForCollisions()
    {
        Actor enemy = getOneIntersectingObject(Enemy.class);
        if (hitDelay == 0 && enemy != null) {
            if (health == 0) {
                AvoiderWorld world = (AvoiderWorld)getWorld();
                world.endGame();
            }
            else {
                health = health - 1;
                nextImage = nextImage + 1;
                setImage("skull" + nextImage + ".png");
                hitDelay = 50;
            }
        }
        if (hitDelay > 0) {
            hitDelay = hitDelay - 1;
        }
    }

    /**
     * 
     */
    protected void addedToWorld(World w)
    {
        leftEye =  new  Eye();
        rightEye =  new  Eye();
        w.addObject(leftEye, getX() - 10, getY() - 8);
        w.addObject(rightEye, getX() + 10, getY() - 8);
    }
}
