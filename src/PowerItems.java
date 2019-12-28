// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * The class contain all the common code for easing and being a power item (power-up or power-down.)
 */
public abstract class PowerItems extends SmoothMover
{
    /* track the ending coordinates*/
    protected double targetX;
    protected double targetY;
    /* The instance variable expireTime specifies how many calls of the act() method this actor should execute before removing itself. In other words, it specifies the lifespan of the actor.*/
    protected double expireTime;
    /* track the starting coordinates*/
    protected double origX;
    protected double origY;
    /* The duration instance variable simply saves the initial value of expireTime. The expireTime variable is continually decremented until it reaches a value of 0, but we need to know its original value for our easing equations.*/
    protected double duration;
    /* The counter variable records how many times this actorhas moved.*/
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
    abstract double curveX();

    /**
     * 
     */
    abstract double curveY();

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
