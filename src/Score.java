/**
 * Game score
 * 
 * @author Michael Haungs
 * @author Jegors Čemisovs
 * @version 2020-01-01
 */
import greenfoot.*;

public class Score extends Actor {
    private Label label;
    private int counter = 0;

    public Score() {
        label = new Label("0", 24, Color.BLACK);
    }

    protected void addedToWorld(World world) {
        world.addObject(label, getX(), getY() + 5);
    }

    public void addScore(int points) {
        counter += points;
        updateImage();
    }

    public int getScore() {
        return counter;
    }

    private void updateImage() {
        getWorld().removeObject(label);
        label = new Label(Integer.toString(counter), 24, Color.BLACK);
        getWorld().addObject(label, getX(), getY() + 5);
    }
}