/**
 * Created by dmitry_ilin on 6/1/17.
 */
public class Projectile extends Sprite{
    private Sprite target;


    public Projectile(int x, int y, int dir, int damage, World world){
        super(x, y, dir, world);
        //setPic("");
        //this.target = target;


    }

    @Override
    public void update(){

    }

    public void getTarget(int radius){
        //if(enemy is in a certain radius and is closest to the projectile){ set the target to that sprite}

    }
}
