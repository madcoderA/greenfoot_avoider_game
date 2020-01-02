import greenfoot.*;

/**
 * The main screen of the game
 * 
 * @author Michael Haungs
 * @author Jegors Čemisovs
 * @version 2020-01-01
 */
public class AvoiderWorld extends World {
    // Background music: "UFO on the streets" by T-balt
    // http://www.newgrounds.com/audio/listen/504436
    private final static GreenfootSound backgroundMusic = new GreenfootSound("UFO_T-Balt.mp3");

    private Score scoreBoard;
    private int enemySpeed = 1;
    private int nextLevel = 50;

    public AvoiderWorld() {
        super(900, 600, 1, false);
        backgroundMusic.playLoop();
        setPaintOrder(Eye.class, Avatar.class, Enemy.class, PowerItems.class);
        prepare();
    }

    private void prepare() {
        generateInitialStarField();
        addObject(new Avatar(), 450, 300);
        scoreBoard = new Score();
        addObject(scoreBoard, 70, 20);
    }

    public void started() {
    }

    public void stopped() {
        if (backgroundMusic.isPlaying())
            backgroundMusic.stop();
    }

    public void act() {
        generateItems();
    }

    void generateItems() {
        for (GeneratedItems item : GeneratedItems.values()) {
            if (!item.isGenerate())
                continue;
            Actor actor = item.getItem();
            addObject(actor, item.getX(), item.getY());
            if (item == GeneratedItems.ENEMY) {
                ((Enemy) actor).setSpeed(enemySpeed);
                // Give us some points for facing yet another enemy
                scoreBoard.addScore(1);
                if (scoreBoard.getScore() > nextLevel) {
                    levelUp();
                }
            }
        }
    }

    private void levelUp() {
        ++enemySpeed;
        nextLevel += 50;
        for (GeneratedItems item : GeneratedItems.values())
            item.nextLevel();
    }

    public void endGame() {
        backgroundMusic.stop();
        final GameOver gameOver = new GameOver();
        gameOver.setPlayerHighScore(scoreBoard.getScore());
        Greenfoot.setWorld(gameOver);
    }

    private void generateInitialStarField() {
        for (int y = getHeight(); y-- > 0;) {
            if (Greenfoot.getRandomNumber(1000) < 350) {
                final Star star = new Star();
                final int x = 5 + Greenfoot.getRandomNumber(getWidth() - 10);
                addObject(star, x, y);
            }
        }
    }
}
