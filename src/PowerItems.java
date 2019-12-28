// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public abstract class PowerItems extends SmoothMover
{
    protected double targetX;
    protected double targetY;
    protected double expireTime;
    protected double origX;
    protected double origY;
    protected double duration;
    protected int counter;

    /**
     * 
     */
    public PowerItems(int tX, int tY, int eT)
    {
        targetX = tX;
        targetY = tY;
        expireTime = eT;
        counter = 0;
        duration = expireTime;
    }

    /**
     * Act - do whatever the PowerItems wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        easing();
        checkHitAvatar();
        checkExpire();
    }

    /**
     * 
     */
    protected void addedToWorld(World w)
    {
        origX = getX();
        origY = getY();
    }

    /**
     * 
     */
    abstract double curveX(double f);

    /**
     * 
     */
    abstract double curveY(double f);

    /**
     * 
     */
    abstract void checkHitAvatar();

    /**
     * 
     */
    protected void easing()
    {
        counter = counter + 1;
        double fX = counter / duration;
        double fY = counter / duration;
        fX = curveX(fX);
        fY = curveY(fY);
        setLocation((targetX * fX) + (origX * (1 - fX)), (targetY * fY) + (origY * (1 - fY)));
    }

    /**
     * 
     */
    private void checkExpire()
    {
        if (expireTime < 0) {
            World w = getWorld();
            if (w != null) {
                w.removeObject(this);
            }
        }
        expireTime = expireTime - 1;
    }
}
