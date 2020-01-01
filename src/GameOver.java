import greenfoot.*;
import java.util.List;

/*
 * Background music: "Disaster" by Lemonnade
 * https://www.newgrounds.com/audio/listen/470536 
 */
public class GameOver extends World {
    private final static GreenfootSound backgroundMusic = new GreenfootSound("Disaster.mp3");

    /**
     * Constructor for objects of class AvoiderGameOverWorld.
     */
    public GameOver() {
        super(600, 400, 1);
        prepare();
        backgroundMusic.playLoop();
        // get the badges!

        List<Badge> badgeList = BadgeCenter.getInstance().getBadges();
        int yPos = 130;
        while (!badgeList.isEmpty()) {
            Badge nextBadge = badgeList.remove(0);
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

    public void setPlayerHighScore(int s) {
        final int FONT_SIZE = 32;
        Label scoreBoardMsg = new Label("Your Score:  " + s, FONT_SIZE);
        addObject(scoreBoardMsg, getWidth() / 2, getHeight() * 2 / 3);
        if (UserInfo.isStorageAvailable()) {
            Label highScoreMsg = new Label("Your Best:  " + recordAndReturnHighScore(s), FONT_SIZE);
            addObject(highScoreMsg, getWidth() / 2, (getHeight() * 2 / 3) + 45);
        }
    }

    private int recordAndReturnHighScore(int newScore) {
        int highScore = 0;
        UserInfo myInfo = UserInfo.getMyInfo();
        highScore = myInfo.getScore();
        if (newScore > highScore) {
            myInfo.setScore(newScore);
            myInfo.store(); // write back to server
            highScore = newScore;
        }
        return highScore;
    }
}
