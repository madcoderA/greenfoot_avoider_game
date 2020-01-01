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
    private int enemySpawnRate = 20;
    private int enemySpeed = 1;
    private int nextLevel = 50;
    private int cupcakeFrequency = 10;
    private int cloverFrequency = 10;
    private int healthFrequency = 1;

    public AvoiderWorld() {
        super(900, 600, 1, false);
        backgroundMusic.playLoop();
        setPaintOrder(Eye.class, Avatar.class, Enemy.class, PowerItems.class);
        prepare();
    }

    private void prepare() {
        generateInitialStarField();
        Avatar avatar = new Avatar();
        addObject(avatar, 450, 300);
        scoreBoard = new Score();
        addObject(scoreBoard, 70, 20);
    }

    public void act() {
        generateEnemies();
        generateStars(-1);
        generatePowerItems();
        increaseLevel();
    }

    private void generateEnemies() {
        // Randomly add enemies to the world
        if (Greenfoot.getRandomNumber(1000) < enemySpawnRate) {
            Enemy e = new Enemy();
            e.setSpeed(enemySpeed);
            addObject(e, Greenfoot.getRandomNumber(getWidth() - 20) + 10, -30);
            // Give us some points for facing yet another enemy
            scoreBoard.addScore(1);
        }
    }

    private void generateStars(int yLoc) {
        // Create a moving background star field
        if (Greenfoot.getRandomNumber(1000) < 350) {
            Star s = new Star();
            GreenfootImage image = s.getImage();
            if (Greenfoot.getRandomNumber(1000) < 300) {
                // this is a close bright star
                s.setSpeed(3);
                image.setTransparency(Greenfoot.getRandomNumber(25) + 225);
                image.scale(4, 4);
            } else {
                // this is a further dim star
                s.setSpeed(2);
                image.setTransparency(Greenfoot.getRandomNumber(50) + 100);
                image.scale(2, 2);
            }
            s.setImage(image);
            addObject(s, Greenfoot.getRandomNumber(getWidth() - 20) + 10, yLoc);
        }
    }

    private void generatePowerItems() {
        generatePowerItem(0, cupcakeFrequency); // new Cupcake
        generatePowerItem(1, cloverFrequency); // new Clover
        generatePowerItem(2, healthFrequency); // new Health
    }

    private Actor createPowerItem(int type, int targetX, int targetY, int expireTime) {
        switch (type) {
        case 0:
            return new Cupcake(targetX, targetY, expireTime);
        case 1:
            return new Clover(targetX, targetY, expireTime);
        case 2:
            return new Rock(targetX, targetY, expireTime);
        }
        return null;
    }

    private void generatePowerItem(int type, int freq) {
        if (Greenfoot.getRandomNumber(1000) < freq) {
            int targetX = Greenfoot.getRandomNumber(getWidth() - 80) + 40;
            int targetY = Greenfoot.getRandomNumber(getHeight() / 2) + 20;
            Actor a = createPowerItem(type, targetX, targetY, 100);
            if (Greenfoot.getRandomNumber(100) < 50) {
                addObject(a, getWidth() + 20, Greenfoot.getRandomNumber(getHeight() / 2) + 30);
            } else {
                addObject(a, -20, Greenfoot.getRandomNumber(getHeight() / 2) + 30);
            }
        }
    }

    private void increaseLevel() {
        final int score = scoreBoard.getScore();

        if (score > nextLevel) {
            enemySpawnRate += 4;
            enemySpeed++;
            cupcakeFrequency += 2;
            cloverFrequency += 3;
            healthFrequency += 1;
            nextLevel += 50;
        }
    }

    public void endGame() {
        backgroundMusic.stop();
        final GameOver go = new GameOver();
        go.setPlayerHighScore(scoreBoard.getScore());
        Greenfoot.setWorld(go);
    }

    private void generateInitialStarField() {
        for (int i = getHeight(); i-- > 0;) {
            generateStars(i);
        }
    }
}
