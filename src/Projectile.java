import java.awt.*;
import java.awt.image.*;
import java.util.ArrayList;

/**
 * Created by dmitry_ilin on 6/1/17.
 */
public class Projectile extends Sprite{
    private Sprite target;
    private int x, y;
    private int damage;
    private int radius;
    private Enemy en;


    public Projectile(int x, int y, int dir, int damage, Enemy e){
        super(x, y, dir);
        this.x = x;
        this.y = y;
        this.damage = damage;
        en= e;
//        radius = r;
        setPic("AirBoomarang.png", NORTH);
        //this.target = target;


    }
//    public void setDamage(int ndam){
//        damage = ndam;
//    }
//    public int getDamage(){
//        return damage;
//    }

    @Override
    public void update(){
        int dir= this.getDirection(this.getLoc(),en.getLoc());
        this.setDir(dir);
        super.update();

    }
    public double getdistance(Sprite other){
        double one= Math.abs(other.getLoc().getX()-x);
        double two=Math.abs(other.getLoc().getY()-y);
        return Math.sqrt((one*one)+(two*two));
    }


    public void getTarget(ArrayList<Sprite> enemy){
        //if(enemy is in a certain radius and is closest to the projectile){ set the target to that sprite}
        for (Sprite e: enemy) {
            if(getdistance(e) <= radius){
                target = e;
                int dir2 = this.getDirection(this.getLoc(), e.getLoc());
                this.setDir(dir2);
            }
        }
    }

    public void draw(Graphics2D g2){
        super.draw(g2);
    }

//    public boolean hit(Sprite other){
//        if(intersects(other) == true){
//            return true;
//        }
//
//        return false;
//    }
}
