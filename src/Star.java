import greenfoot.*;

public class Star extends Actor
{
    protected int twinkleTime = 0;
    protected int currentTransparency = 0;
    int speed = 1;

    public Star()
    {
        GreenfootImage img =  new GreenfootImage(10, 10);
        img.setColor(Color.WHITE);
        img.fillOval(0, 0, 10, 10);
        setImage(img);
    }

    public void act()
    {
        setLocation(getX(), getY() + speed);
        checkRemove();
        checkTwinkle();
    }

    private void checkRemove()
    {
        World w = getWorld();
        if (getY() > w.getHeight() + 30) {
            w.removeObject(this);
        }
    }

    public void setSpeed(int s)
    {
        speed = s;
    }

    private void checkTwinkle()
    {
        GreenfootImage img = getImage();
        if (twinkleTime > 0) {
            if (twinkleTime == 1) {
                img.setTransparency(currentTransparency);
            }
            twinkleTime = twinkleTime - 1;
        }
        else {
            if (Greenfoot.getRandomNumber(10000) < 10) {
                twinkleTime = 10;
                currentTransparency = img.getTransparency();
                img.setTransparency(0);
            }
        }
    }
}
