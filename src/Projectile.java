import java.util.ArrayList;

/**
 * Created by dmitry_ilin on 6/1/17.
 */
public class Projectile extends Sprite{
    private Sprite target;
    private int x, y;


    public Projectile(int x, int y, int dir, int damage, World world){
        super(x, y, dir, world);
        this.x = x;
        this.y = y;
        //setPic("");
        //this.target = target;


    }

    @Override
    public void update(){


    }
    public double getdistance(Sprite other){
        double one= Math.abs(other.getLoc().getX()-x);
        double two=Math.abs(other.getLoc().getY()-y);
        return Math.sqrt((one*one)+(two*two));
    }

    public void getTarget(int radius, ArrayList<Sprite> enemy){
        //if(enemy is in a certain radius and is closest to the projectile){ set the target to that sprite}
        for (Sprite e: enemy) {
            if(getdistance(e) <= radius){
                target = e;
                int dir2 = this.getDirection(this.getLoc(), e.getLoc());
                this.setDir(dir2);
            }
        }
    }

//    public boolean hit(Sprite other){
//        if(intersects(other) == true){
//            return true;
//        }
//
//        return false;
//    }
}
