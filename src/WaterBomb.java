import java.awt.image.*;

/**
 * Created by samuel_wolff on 6/10/17.
 */
public class WaterBomb extends Projectile {
    private Sprite target;
    private int x, y;
    private int damage;
    private int radius;
    BufferedImage pic;
    public WaterBomb(int x, int y, int dir, int damage, BufferedImage pi,Enemy en){
        super(x,y,dir,damage,pi,en);
        this.x = x;
        this.y = y;
        pic=pi;
        this.setSpeed(30);
        this.damage = 5;
        this.setPic("WaterBlast.png",0);
    }

}
