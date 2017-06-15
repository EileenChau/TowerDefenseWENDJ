import java.awt.image.*;

/**
 * Created by dimai on 6/5/2017.
 */
public class Fire extends Projectile {
    private BufferedImage pic;

    public Fire(int x, int y, int dir, int damage, int radius,BufferedImage pi, Enemy en){
        super(x, y, dir, 5, en);
        setPic("FireFR.png", NORTH);


    }
}
