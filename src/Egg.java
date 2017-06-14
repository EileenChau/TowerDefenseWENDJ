/**
 * Created by eileen_chau on 6/14/17.
 */
public class Egg extends Projectile {

    public Egg(int x, int y, int dir, Enemy e) {
        super(x, y, dir, 5, e);
        setSpeed(30);
        setPic("Egg.png", NORTH);
    }

}
