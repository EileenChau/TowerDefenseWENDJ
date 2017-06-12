import java.awt.image.*;

/**
 * Created by samuel_wolff on 6/12/17.
 */
public class Fireball extends Projectile {
    public Fireball(int x, int y, int dir, int damage, BufferedImage pic, Enemy e) {
        super(x, y, dir, damage, pic, e);
    }
}
