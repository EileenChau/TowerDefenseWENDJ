/**
 * Created by eileen_chau on 6/14/17.
 */
public class LightningBolt extends Projectile {

    public LightningBolt(int x, int y, int dir, Enemy e) {
        super(x, y, dir, 5, e);
        setSpeed(30);
        setPic("LightningBolt.png", NORTH);
    }
}
