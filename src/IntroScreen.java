import greenfoot.*;

/**
 * Intro Screen
 * 
 * @author Michael Haungs
 * @author Jegors Čemisovs
 * @version 2020-01-01
 */
public class IntroScreen extends World {
    // Background music: "Space Warning" by Zakhej
    // https://www.newgrounds.com/audio/listen/485972
    private final static GreenfootSound backgroundMusic = new GreenfootSound("Hektik_Space.mp3");

    private Actor startButton;
    private Actor creditButton;
    private Actor storyButton;

    /**
     * Constructor for objects of class IntroScreen.
     */
    public IntroScreen() {
        super(900, 600, 1);
        startButton = addButton("Start Game", getWidth() / 2, getHeight() * 2 / 3);
        creditButton = addButton("Credits Screen", getWidth() / 2, (getHeight() * 2 / 3) + 40);
        storyButton = addButton("Story Screen", getWidth() / 2, (getHeight() * 2 / 3) + 80);
    }

    public void started() {
        if (!backgroundMusic.isPlaying())
            backgroundMusic.playLoop();
    }

    public void stopped() {
        if (backgroundMusic.isPlaying())
            backgroundMusic.stop();
    }

    public void act() {
        // Start the game if the user clicks the mouse anywhere
        if (Greenfoot.mouseClicked(startButton)) {
            backgroundMusic.stop();
            Greenfoot.setWorld(new AvoiderWorld());
        } else if (Greenfoot.mouseClicked(creditButton))
            Greenfoot.setWorld(new CreditScreen());
        else if (Greenfoot.mouseClicked(storyButton))
            Greenfoot.setWorld(new StoryScreen());
    }

    private Actor addButton(String text, int x, int y) {
        final Actor button = new Label(text, 24);
        addObject(button, x, y);
        return button;
    }
}
