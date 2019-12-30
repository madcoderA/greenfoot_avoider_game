import greenfoot.*;

public class Badge extends Actor {
    GreenfootImage bkg;
    GreenfootImage msg;
    
    public Badge(String s) {
        bkg = getImage();
        msg = new GreenfootImage(s, 14, Color.WHITE, null);
        bkg.drawImage(msg, 10, 20);
        setImage(bkg);
    }

}