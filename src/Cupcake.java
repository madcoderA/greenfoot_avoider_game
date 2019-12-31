/**
 * Behavior implementation for Cupcake.
 * 
 * @author Jegors Čemisovs
 * @version 2019-12-31
 */
public class Cupcake extends PowerItems {
    private BadgeCenter badgeCenter;

    public Cupcake(int tX, int tY, int eT) {
        super(tX, tY, eT);
        badgeCenter = BadgeCenter.getInstance();
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
            badgeCenter.hitCupcake();
            avatar.sayWoot();
            avatar.stun();
            getWorld().removeObject(this);
        }
    }
}
