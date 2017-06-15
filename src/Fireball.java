import java.awt.image.*;

/**
 * Created by samuel_wolff on 6/12/17.
 */
public class Fireball extends Projectile {

    public Fireball(int x, int y, int dir, Enemy e, BufferedImage pic) {
        super(x, y, dir, 5, e);
        setSpeed(30);
        setPic("Mario Fireball.png", NORTH);
    }
}
