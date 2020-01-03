import greenfoot.*;
import java.util.List;

/**
 * Game Over Screen
 * 
 * @author Michael Haungs
 * @author Jegors Čemisovs
 * @version 2020-01-01
 */
public class GameOver extends World {
    // Background music: "Disaster" by Lemonnade
    // https://www.newgrounds.com/audio/listen/470536
    private final static GreenfootSound backgroundMusic = new GreenfootSound("Disaster.mp3");

    /**
     * Constructor for objects of class AvoiderGameOverWorld.
     */
    public GameOver() {
        super(900, 600, 1);
        prepare();
        backgroundMusic.playLoop();
        // get the badges!

        final List<Badge> badgeList = BadgeCenter.getInstance().getBadges();
        int yPos = 130;
        while (!badgeList.isEmpty()) {
            final Badge nextBadge = badgeList.remove(0);
            addObject(nextBadge, 60, yPos);
            yPos += 70;
        }
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            backgroundMusic.stop();
            Greenfoot.setWorld(new AvoiderWorld());
        }
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare() {
    }

    public void stopped() {
        if (backgroundMusic.isPlaying())
            backgroundMusic.stop();
    }

    public void setPlayerHighScore(int s) {
        final int FONT_SIZE = 32;
        final Label scoreBoardMsg = new Label("Your Score:  " + s, FONT_SIZE);
        addObject(scoreBoardMsg, getWidth() / 2, getHeight() * 2 / 3);
        if (UserInfo.isStorageAvailable()) {
            final Label highScoreMsg = new Label("Your Best:  " + recordAndReturnHighScore(s), FONT_SIZE);
            addObject(highScoreMsg, getWidth() / 2, (getHeight() * 2 / 3) + 45);
        }
    }

    private int recordAndReturnHighScore(int newScore) {
        final UserInfo myInfo = UserInfo.getMyInfo();
        int highScore = myInfo.getScore();
        if (newScore > highScore) {
            myInfo.setScore(newScore);
            myInfo.store(); // write back to server
            highScore = newScore;
        }
        return highScore;
    }
}
