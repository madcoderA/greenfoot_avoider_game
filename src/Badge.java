/**
 * Badge
 * 
 * @author Jegors Čemisovs
 * @version 2020-01-01
 */
import greenfoot.*;

public class Badge extends Actor {
    final static int FONT_SIZE = 12;

    public Badge(String name) {
        final GreenfootImage background = getImage();
        final GreenfootImage message = new GreenfootImage(name, FONT_SIZE, Color.WHITE, null);
        background.drawImage(message, 10, 20);
        setImage(background);
    }
}