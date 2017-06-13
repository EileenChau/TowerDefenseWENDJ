import java.awt.image.*;

/**
 * Created by dimai on 6/5/2017.
 */
public class Fire extends Projectile {
    private BufferedImage pic;
    private Sprite target;
    private int x, y;
    private int damage;
    private int radius;
    public Fire(int x, int y, int dir, int damage, int radius,BufferedImage pi, Enemy en){
        super(x, y, dir, 5,pi, en);
        setPic("Mario Fire.png", NORTH);
        this.x = x;
        this.y = y;
        pic=pi;
        this.setSpeed(30);
        this.damage = 5;
        this.setPic("WaterBlast.png",0);
    }
}
