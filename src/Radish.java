/**
 * Created by eileen_chau on 6/14/17.
 */
public class Radish extends Projectile {

    public Radish(int x, int y, int dir, Enemy e) {
        super(x, y, dir, 5, e);
        setSpeed(30);
        setPic("Radish.png", NORTH);
    }
}
