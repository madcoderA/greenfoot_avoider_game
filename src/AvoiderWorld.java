// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * This is a simple game
 */
public class AvoiderWorld extends World
{
    private GreenfootSound backgroundMusic =  new  GreenfootSound("UFO-on-the-streets.mp3");
    private int spawnRate = 20;
    private int speed = 1;
    private Counter scoreBoard;
    private static final int START_LINE = -30;
    private int nextLevel = 100;

    /**
     * Constructor for objects of class MyWorld.
     */
    public AvoiderWorld()
    {
        super(600, 400, 1, false);
        setPaintOrder(Eye.class, Avatar.class, Enemy.class, Counter.class);
        backgroundMusic.playLoop();
        generateInitialStarField();
        prepare();
    }

    /**
     * 
     */
    public void act()
    {
        generateStars(-1);
        generateEnemies();
        increaseLevel();
    }

    /**
     * 
     */
    private void generateInitialStarField()
    {
        int i = 0;
        while (i < getHeight()) {
            generateStars(i);
            i = i + 1;
        }
    }

    /**
     * 
     */
    public void generateEnemies()
    {
        if (Greenfoot.getRandomNumber(1000) < spawnRate) {
            Enemy enemy =  new  Enemy();
            enemy.setSpeed(speed);
            addObject(enemy, Greenfoot.getRandomNumber(getWidth() - 20) + 10, START_LINE);
            scoreBoard.add(1);
        }
    }

    /**
     * 
     */
    private void generateStars(int yLoc)
    {
        if (Greenfoot.getRandomNumber(1000) < 350) {
            Star s =  new  Star();
            GreenfootImage image = s.getImage();
            if (Greenfoot.getRandomNumber(1000) < 300) {
                /* this is a close bright star*/
                s.setSpeed(3);
                image.setTransparency(Greenfoot.getRandomNumber(25) + 225);
                image.scale(4, 4);
            }
            else {
                /* this is a further dim star*/
                s.setSpeed(2);
                image.setTransparency(Greenfoot.getRandomNumber(50) + 100);
                image.scale(2, 2);
            }
            s.setImage(image);
            addObject(s, Greenfoot.getRandomNumber(getWidth() - 20) + 10, yLoc);
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Avatar avatar =  new  Avatar();
        addObject(avatar, 287, 232);
        scoreBoard =  new  Counter("Score: ");
        addObject(scoreBoard, 70, 20);
    }

    /**
     * 
     */
    public void endGame()
    {
        backgroundMusic.stop();
        GameOver go =  new  GameOver();
        go.setFinalScore(scoreBoard.getValue());
        Greenfoot.setWorld(go);
    }

    /**
     * 
     */
    public void increaseLevel()
    {
        final int score = scoreBoard.getValue();
        if (score > nextLevel) {
            spawnRate = spawnRate + 2;
            speed = speed + 1;
            nextLevel = nextLevel + 100;
        }
    }
}
