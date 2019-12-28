// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Star extends Actor
{
    private int speed = 1;

    /**
     * 
     */
    public Star()
    {
        GreenfootImage img =  new GreenfootImage(10, 10);
        img.setColor(Color.WHITE);
        img.fillOval(0, 0, 10, 10);
        setImage(img);
    }

    /**
     * 
     */
    public void act()
    {
        setLocation(getX(), getY() + speed);
        checkRemove();
    }

    /**
     * 
     */
    private void checkRemove()
    {
        World w = getWorld();
        if (getY() > w.getHeight() + 30) {
            w.removeObject(this);
        }
    }

    /**
     * 
     */
    public void setSpeed(int s)
    {
        speed = s;
    }
}
