import java.awt.image.*;

/**
 * Created by samuel_wolff on 6/10/17.
 */
public class WaterBomb extends Projectile {

    public WaterBomb(int x, int y, int dir, Enemy en, BufferedImage pic){
        super(x,y,dir,5,en);
        setSpeed(30);
        setPic("WaterBlast.png", NORTH);
    }

}
