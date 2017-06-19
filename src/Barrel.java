/**
 * Created by samuel_wolff on 6/19/17.
 */
public class Barrel extends Projectile {
    public Barrel(int x, int y, int dir, int damage, Enemy e) {
        super(x, y, dir, damage, e);
        this.setPic("Barrel.png",NORTH);
    }
}
