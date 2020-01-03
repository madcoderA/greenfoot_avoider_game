import greenfoot.*;

/**
 * Behavior implementation for Credit Screen.
 * 
 * @author Michael Haungs
 * @author Jegors Čemisovs
 * @version 2019-12-31
 */
public class CreditScreen extends World {

    public CreditScreen() {
        super(900, 600, 1);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) 
            Greenfoot.setWorld(new IntroScreen());
    }
}
