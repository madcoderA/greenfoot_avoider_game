import greenfoot.*;

public class Badge extends Actor {
    GreenfootImage background;
    GreenfootImage message;
    // Font font = new Font(12);

    public Badge(String name) {
        background = getImage();
        message = new GreenfootImage(name, 10, Color.WHITE, null);
        background.drawImage(message, 10, 20);
        setImage(background);
    }

}