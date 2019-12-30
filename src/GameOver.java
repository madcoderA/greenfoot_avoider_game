import greenfoot.*; 
import java.nio.*;
import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public class GameOver extends World
{
    private GreenfootSound backgroundMusic =  new GreenfootSound("Disaster.mp3");

    /**
     * Constructor for objects of class AvoiderGameOverWorld.
     */
    public GameOver()
    {
        super(600, 400, 1);
        prepare();
        backgroundMusic.playLoop();
        // get the badges!
        
        List<Badge> badgeList = BadgeCenter.getInstance().getBadges();
        int yPos = 140;
        while(!badgeList.isEmpty()) {
            Badge nextBadge = badgeList.remove(0);
            addObject(nextBadge, 65, yPos);
            yPos += 70;
        } 
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            backgroundMusic.stop();
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

    public void setPlayerHighScore(String s) {
        final int FONT_SIZE = 22;
        Label scoreBoardMsg = new Label("Your Score:  " + s, FONT_SIZE);
        Label highScoreMsg = new Label("Your Best:  " + recordAndReturnHighScore(s), FONT_SIZE);
        addObject(scoreBoardMsg, getWidth()/5, getHeight() * 2 / 3 + 25);
        addObject(highScoreMsg, getWidth()/5, (getHeight() * 2 / 3) + 60);
    }

    private String recordAndReturnHighScore(String s) {
        String hs = null;
        try {
            Path scoreFile = Paths.get("./scoreFile.txt");

            if( Files.exists(scoreFile) ) {
                byte[] bytes = Files.readAllBytes(scoreFile);
                hs = new String(bytes);

                if( Integer.parseInt(s) > Integer.parseInt(hs) ) {
                    Files.write(scoreFile, s.getBytes());  // Default is CREATE | TRUNCATE_EXISTING | WRITE
                    hs = s;
                }
            } else {
                Files.write(scoreFile, s.getBytes());
                hs = s;
            }

        } catch( IOException e ) {
            System.out.println("IOException");
        }
        
        return hs;
    }
}
