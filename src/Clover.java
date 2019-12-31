/**
 * Behavior implementation for Clover.
 * 
 * @author Jegors Čemisovs
 * @version 2019-12-31
 */
import java.lang.Math;

public class Clover extends PowerItems {
    private BadgeCenter badgeCenter;

    public Clover(int tX, int tY, int eT) {
        super(tX, tY, eT);
        badgeCenter = BadgeCenter.getInstance();
    }

    protected double curveX(double f) {
        return f;
    }

    protected double curveY(double f) {
        return Math.sin(4 * f);
    }

    protected void checkHitAvatar() {
        Avatar avatar = (Avatar) getOneIntersectingObject(Avatar.class);
        if (avatar != null) {
            badgeCenter.hitClover();
            avatar.sayWoot();
            avatar.lagControls();
            getWorld().removeObject(this);
        }
    }
}