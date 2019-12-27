// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Avatar extends Actor
{

    /**
     * 
     */
    public void followMouse()
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (mi != null) {
            setLocation(mi.getX(), mi.getY());
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
        if (enemy != null) {
            AvoiderWorld world = (AvoiderWorld)getWorld();
            world.endGame();
        }
    }
}
