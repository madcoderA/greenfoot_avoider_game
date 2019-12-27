// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Enemy extends Actor
{
    private int speed = 1;

    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(getX(), getY() + speed);
        checkRemove();
    }

    /**
     * Checks is the enemy behinde the scene and remove it
     */
    public void checkRemove()
    {
        World w = getWorld();
        if (getY() > w.getHeight() + 30) {
            w.removeObject(this);
        }
    }

    /**
     * Set speed for the enemy
     */
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }
}
