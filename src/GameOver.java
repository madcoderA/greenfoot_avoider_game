import greenfoot.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/*
 * Background music: "Disaster" by Lemonnade
 * https://www.newgrounds.com/audio/listen/470536 
 */
public class GameOver extends World {
    private GreenfootSound backgroundMusic = new GreenfootSound("Disaster.mp3");

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
            AvoiderWorld world = new AvoiderWorld();
            Greenfoot.setWorld(world);
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
        Label highScoreMsg = new Label("Your Best:  " + recordAndReturnHighScore(s), FONT_SIZE);
        addObject(scoreBoardMsg, getWidth() / 2, getHeight() * 2 / 3);
        addObject(highScoreMsg, getWidth() / 2, (getHeight() * 2 / 3) + 45);
    }

    private int recordAndReturnHighScore(int newScore) {
        int highScore = 0;

        if (UserInfo.isStorageAvailable()) {
            UserInfo myInfo = UserInfo.getMyInfo();
            highScore = myInfo.getScore();
            if (newScore > highScore) {
                myInfo.setScore(newScore);
                myInfo.store(); // write back to server
                highScore = newScore;
            }
        } else {

            try {
                Path scoreFile = Paths.get("./scoreFile.txt");

                if (Files.exists(scoreFile)) {
                    byte[] bytes = Files.readAllBytes(scoreFile);
                    highScore = Integer.parseInt(new String(bytes));

                    if (newScore > highScore) {
                        Files.write(scoreFile, Integer.toString(newScore).getBytes()); // Default is CREATE |
                                                                                       // TRUNCATE_EXISTING | WRITE
                        highScore = newScore;
                    }
                } else {
                    Files.write(scoreFile, Integer.toString(newScore).getBytes());
                    highScore = newScore;
                }

            } catch (IOException e) {
                System.out.println("IOException");
            }
        }
        return highScore;
    }
}
