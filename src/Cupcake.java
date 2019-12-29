import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Cupcake extends PowerItems
{

    /**
     * 
     */
    public Cupcake(int tX, int tY, int eT)
    {
        super(tX, tY, eT);
    }

    /**
     * Act - do whatever the Cupcake wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
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
        return f;
    }

    /**
     * 
     */
    protected void checkHitAvatar()
    {
        Avatar a = (Avatar)getOneIntersectingObject(Avatar.class);
        if (a != null) {
            a.stun();
            getWorld().removeObject(this);
        }
    }
}
