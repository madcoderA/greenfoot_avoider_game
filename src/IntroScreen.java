import greenfoot.*;

/**
 * Intro Screen
 * 
 * @author Jegors Čemisovs
 * @version 2020-01-01
 */

public class IntroScreen extends World {
    // Background music: "Space Hero" by Sandlersongs
    // https://www.newgrounds.com/audio/listen/223466
    // private final GreenfootSound backgroundMusic = new GreenfootSound("Space_Hero.mp3");
    
    Actor startButton;
    Actor creditButton;
    Actor storyButton;

    /**
     * Constructor for objects of class IntroScreen.
     */
    public IntroScreen() {
        super(900, 600, 1);
        // backgroundMusic.playLoop();
        startButton = addButton("Start Game", getWidth() / 2, getHeight() * 2 / 3);
        creditButton = addButton("Credits Screen", getWidth() / 2, (getHeight() * 2 / 3) + 40);
        storyButton = addButton("Story Screen", getWidth() / 2, (getHeight() * 2 / 3) + 80);
    }

    public void act() {
        // Start the game if the user clicks the mouse anywhere
        if (Greenfoot.mouseClicked(startButton)) {
            // backgroundMusic.stop();
            Greenfoot.setWorld(new AvoiderWorld());
        }
        else if (Greenfoot.mouseClicked(creditButton))
            Greenfoot.setWorld(new CreditScreen());
        else if (Greenfoot.mouseClicked(storyButton))
            Greenfoot.setWorld(new StoryScreen());
    }

    private Actor addButton(String text, int x, int y) {
        Actor button = new Label(text, 24);
        addObject(button, x, y);
        return button;
    }
}
