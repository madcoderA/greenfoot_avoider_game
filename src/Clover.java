import lang.stride.*;
import java.util.*;
import java.lang.Math;
import greenfoot.*;

/**
 * 
 */
public class Clover extends PowerItems
{

    /**
     * 
     */
    public Clover(int tX, int tY, int eT)
    {
        super(tX, tY, eT);
    }

    /**
     * Act - do whatever the Clover wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
    }

    /**
     * 
     */
    protected double curveX(double f)
    {
        return f;
    }

    /**
     * 
     */
    protected double curveY(double f)
    {
        return Math.sin(4 * f);
    }

    /**
     * 
     */
    protected void checkHitAvatar()
    {
        Avatar a = (Avatar)getOneIntersectingObject(Avatar.class);
        if (a != null) {
            a.lagControls();
            getWorld().removeObject(this);
        }
    }
}
