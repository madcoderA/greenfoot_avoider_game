import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CreditScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CreditScreen extends World
{

    /**
     * Constructor for objects of class CreditScreen.
     * 
     */
    public CreditScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }
    
    public void act() {
        if( Greenfoot.mouseClicked(this) ) {
            World w = new IntroScreen();
            Greenfoot.setWorld(w);
        }
    }
}
