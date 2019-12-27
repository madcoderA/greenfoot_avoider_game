// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class GameOver extends World
{
    private Counter finalScore =  new  Counter("Final Score: ");

    /**
     * Constructor for objects of class AvoiderGameOverWorld.
     */
    public GameOver()
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
            AvoiderWorld world =  new  AvoiderWorld();
            Greenfoot.setWorld(world);
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(finalScore, 131, 334);
        finalScore.act();
    }

    /**
     * 
     */
    public void setFinalScore(int finalScore)
    {
        this.finalScore.setValue(finalScore);
        this.finalScore.act();
    }
}
