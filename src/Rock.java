/**
 * Behavior implementation for Rock.
 * 
 * @author Jegors Čemisovs
 * @version 2019-12-31
 */
public class Rock extends PowerItems {
    private BadgeCenter badgeCenter;

    public Rock(int tX, int tY, int eT) {
        super(tX, tY, eT);
        badgeCenter = BadgeCenter.getInstance();
    }

    protected double curveX(double f) {
        return f;
    }

    protected double curveY(double f) {
        // return Math.sin(f); // Best ease-in evah!
        return f * f * f;
    }

    protected void checkHitAvatar() {
        Avatar avatar = (Avatar) getOneIntersectingObject(Avatar.class);
        if (avatar != null) {
            badgeCenter.hitRock();
            avatar.sayAhhh();
            avatar.addHealth();
            getWorld().removeObject(this);
        }
    }
}
