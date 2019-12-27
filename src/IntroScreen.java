// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class IntroScreen extends World
{

    /**
     * Constructor for objects of class IntroScreen.
     */
    public IntroScreen()
    {
        super(600, 400, 1);
        prepare();
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

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
