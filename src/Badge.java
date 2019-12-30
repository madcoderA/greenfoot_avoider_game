import greenfoot.*;

public class Badge extends Actor {
    GreenfootImage bkg;
    GreenfootImage msg;
    // Font font = new Font(12);
    
    public Badge(String name) {
        bkg = getImage();
        msg = new GreenfootImage(name, 10, Color.WHITE, null);
        bkg.drawImage(msg, 10, 20);
        setImage(bkg);
    }

}