// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Rock extends PowerItems
{

    /**
     * 
     */
    public Rock(int tX, int tY, int eT)
    {
        super(tX, tY, eT);
    }

    /**
     * Act - do whatever the Rock wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
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
        return f * f * f;
    }

    /**
     * 
     */
    protected void checkHitAvatar()
    {
        Avatar a = (Avatar)getOneIntersectingObject(Avatar.class);
        if (a != null) {
            a.addHealth();
            getWorld().removeObject(this);
        }
    }
}
