/**
 * Game score
 * 
 * @author Jegors Čemisovs
 * @version 2020-01-01
 */
import greenfoot.*;

public class Score extends Actor {
    private Label msg;
    private int counter = 0;

    public Score() {
        msg = new Label("0", 24, Color.BLACK);
    }

    protected void addedToWorld(World w) {
        w.addObject(msg, getX(), getY() + 5);
    }

    public void addScore(int points) {
        counter += points;
        updateImage();
    }

    public int getScore() {
        return counter;
    }

    private void updateImage() {
        getWorld().removeObject(msg);
        msg = new Label(Integer.toString(counter), 24, Color.BLACK);
        getWorld().addObject(msg, getX(), getY() + 5);
    }
}