import greenfoot.*;

public class Enemy extends Actor
{
    private int timeToChange = 1;
    private int speed = 1;

    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(getX(), getY() + speed);
        changeDisposition();
        checkRemove();
    }

    /**
     * Checks is the enemy behinde the scene and remove it
     */
    public void checkRemove()
    {
        World world = getWorld();
        if (getY() > world.getHeight() + 30) {
            world.removeObject(this);
        }
    }

    /**
     * Set speed for the enemy
     */
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

    public void changeDisposition()
    {
        int ypos = getY();
        final int worldHeight = getWorld().getHeight();
        final int marker1 = (int)(worldHeight * 0.5);
        final int marker2 = (int)(worldHeight * 0.75);
        final int marker3 = (int)(worldHeight * 0.90);
        if (timeToChange == 1 && ypos > marker1) {
            setImage("smiley4.png");
            timeToChange = timeToChange + 1;
        }
        else if (timeToChange == 2 && ypos > marker2) {
            setImage("smiley3.png");
            timeToChange = timeToChange + 1;
        }
        else if (timeToChange == 3 && ypos > marker3) {
            setImage("smiley5.png");
            timeToChange = timeToChange + 1;
        }
    }
}
