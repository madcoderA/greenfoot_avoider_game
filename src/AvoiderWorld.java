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
        addObject(new Avatar(), 450, 300);
        scoreBoard = new Score();
        addObject(scoreBoard, 70, 20);
    }

    public void started() {
    }

    public void stopped() {
        if (backgroundMusic.isPlaying())
            backgroundMusic.playLoop();
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
            final Enemy enemy = new Enemy();
            enemy.setSpeed(enemySpeed);
            addObject(enemy, Greenfoot.getRandomNumber(getWidth() - 20) + 10, -30);
            // Give us some points for facing yet another enemy
            scoreBoard.addScore(1);
        }
    }

    private void generateStars(int yLoc) {
        // Create a moving background star field
        if (Greenfoot.getRandomNumber(1000) < 350) {
            final Star star = new Star();
            final GreenfootImage image = star.getImage();
            if (Greenfoot.getRandomNumber(1000) < 300) {
                // this is a close bright star
                star.setSpeed(3);
                image.setTransparency(Greenfoot.getRandomNumber(25) + 225);
                image.scale(4, 4);
            } else {
                // this is a further dim star
                star.setSpeed(2);
                image.setTransparency(Greenfoot.getRandomNumber(50) + 100);
                image.scale(2, 2);
            }
            star.setImage(image);
            addObject(star, Greenfoot.getRandomNumber(getWidth() - 20) + 10, yLoc);
        }
    }

    private void generatePowerItems() {
        generatePowerItem(0, cupcakeFrequency); // new Cupcake
        generatePowerItem(1, cloverFrequency); // new Clover
        generatePowerItem(2, healthFrequency); // new Health
    }

    private void generatePowerItem(int type, int freq) {
        if (Greenfoot.getRandomNumber(1000) < freq) {
            int targetX = Greenfoot.getRandomNumber(getWidth() - 80) + 40;
            int targetY = Greenfoot.getRandomNumber(getHeight() / 2) + 20;
            Actor powerItem = createPowerItem(type, targetX, targetY, 100);
            if (Greenfoot.getRandomNumber(100) < 50) {
                addObject(powerItem, getWidth() + 20, Greenfoot.getRandomNumber(getHeight() / 2) + 30);
            } else {
                addObject(powerItem, -20, Greenfoot.getRandomNumber(getHeight() / 2) + 30);
            }
        }
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
        final GameOver gameOver = new GameOver();
        gameOver.setPlayerHighScore(scoreBoard.getScore());
        Greenfoot.setWorld(gameOver);
    }

    private void generateInitialStarField() {
        for (int i = getHeight(); i-- > 0;) {
            generateStars(i);
        }
    }
}
