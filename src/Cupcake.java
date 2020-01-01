/**
 * Behavior implementation for Cupcake.
 * 
 * @author Jegors Čemisovs
 * @version 2020-01-01
 */
public class Cupcake extends PowerItems {

    public Cupcake(int targetX, int targetY, int expireTime) {
        super(targetX, targetY, expireTime);
    }

    protected double curveX(double f) {
        return f;
    }

    protected double curveY(double f) {
        return f;
    }

    protected void checkHitAvatar() {
        Avatar avatar = (Avatar) getOneIntersectingObject(Avatar.class);
        if (avatar != null) {
            BadgeCenter.getInstance().hitCupcake();
            avatar.sayWoot();
            avatar.stun();
            getWorld().removeObject(this);
        }
    }
}
