/**
 * Behavior implementation for Clover.
 * 
 * @author Jegors Čemisovs
 * @version 2019-12-31
 */
import java.lang.Math;

public class Clover extends PowerItems {

    public Clover(int targetX, int targetY, int expireTime) {
        super(targetX, targetY, expireTime);
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
            BadgeCenter.getInstance().hitClover();
            avatar.sayWoot();
            avatar.lagControls();
            getWorld().removeObject(this);
        }
    }
}