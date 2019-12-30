import greenfoot.*;

public class IntroScreen extends World
{
    Actor startButton, creditButton, storyButton;
    
    /**
     * Constructor for objects of class IntroScreen.
     */
    public IntroScreen()
    {
        super(600, 400, 1);
        startButton = addButton("Start Game", getWidth()/2, getHeight()*2/3);
        creditButton = addButton("Credits Screen", getWidth()/2, (getHeight()*2/3) + 40);
        storyButton = addButton("Story Screen", getWidth()/2, (getHeight()*2/3) + 80);
    }

    public void act()
    {
        // Start the game if the user clicks the mouse anywhere 
        if( Greenfoot.mouseClicked(startButton) ) {
            AvoiderWorld world = new AvoiderWorld();
            Greenfoot.setWorld(world);
        } else if( Greenfoot.mouseClicked(creditButton) ) {
            CreditScreen world = new CreditScreen();
            Greenfoot.setWorld(world);
        } else if( Greenfoot.mouseClicked(storyButton) ) {
            StoryScreen world = new StoryScreen();
            Greenfoot.setWorld(world);
        }
    }

    private Actor addButton(String text, int x, int y) {
        Actor button = new Label(text, 24);
        addObject(button, x, y);
        return button;
    }
}
