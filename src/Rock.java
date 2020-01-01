/**
 * Behavior implementation for Rock.
 * 
 * @author Jegors Čemisovs
 * @version 2020-01-01
 */
public class Rock extends PowerItems {

    public Rock(int targetX, int targetY, int expireTime) {
        super(targetX, targetY, expireTime);
    }

    protected double curveX(double f) {
        return f;
    }

    protected double curveY(double f) {
        return f * f * f;
    }

    protected void checkHitAvatar() {
        Avatar avatar = (Avatar) getOneIntersectingObject(Avatar.class);
        if (avatar != null) {
            BadgeCenter.getInstance().hitRock();
            avatar.sayAhhh();
            avatar.addHealth();
            getWorld().removeObject(this);
        }
    }
}
