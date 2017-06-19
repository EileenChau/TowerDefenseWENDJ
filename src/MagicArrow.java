/**
 * Created by samuel_wolff on 6/19/17.
 */
public class MagicArrow extends Projectile {
    public MagicArrow(int x, int y, int dir, int damage, Enemy e) {
        super(x, y, dir, damage, e);
        this.setPic("MagicArrow.png", NORTH);
    }
}
