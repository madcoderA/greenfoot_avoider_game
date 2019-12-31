/**
 * Game score
 * 
 * @author Jegors Čemisovs
 * @version 2019-12-31
 */
import greenfoot.*;

public class Score extends Actor {
    final static int FONT_SIZE = 24;
    Label label;
    int counter = 0;

    public Score() {
        label = new Label("0", FONT_SIZE, Color.BLACK);
    }

    protected void addedToWorld(World world) {
        world.addObject(label, getX(), getY() + 5);
    }

    public void addScore(int points) {
        counter = counter + points;
        updateImage();
    }

    public int getScore() {
        return counter;
    }

    private void updateImage() {
        getWorld().removeObject(label);
        label = new Label(Integer.toString(counter), FONT_SIZE, Color.BLACK);
        getWorld().addObject(label, getX(), getY() + 5);
    }

}