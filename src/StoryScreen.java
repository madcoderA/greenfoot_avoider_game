import greenfoot.*;

/**
 * Behavior implementation for Story Screen.
 * 
 * @author Jegors Čemisovs
 * @version 2019-12-31
 */
public class StoryScreen extends World {

    public StoryScreen() {
        super(900, 600, 1);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this))
            Greenfoot.setWorld(new IntroScreen());
    }
}
