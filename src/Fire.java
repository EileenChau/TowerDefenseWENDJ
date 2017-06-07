/**
 * Created by dimai on 6/5/2017.
 */
public class Fire extends Projectile {

    public Fire(int x, int y, int dir, int damage, int radius){
        super(x, y, dir, 5, 10);
        setPic("FireFR.png", NORTH);

    }
}
