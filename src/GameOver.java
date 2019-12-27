// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class GameOver extends World
{

    /**
     * Constructor for objects of class AvoiderGameOverWorld.
     */
    public GameOver()
    {
        super(600, 400, 1);
    }

    /**
     * 
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            AvoiderWorld world =  new AvoiderWorld();
            Greenfoot.setWorld(world);
        }
    }
}
