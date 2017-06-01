/**
 * Created by dmitry_ilin on 6/1/17.
 */
public class Projectile extends Sprite{

    public Projectile(int x, int y, int dir, int damage, World world, Sprite target){
        super(x, y, dir, world);

    }

    public boolean intersects(Sprite other){

        return false;
    }
}
