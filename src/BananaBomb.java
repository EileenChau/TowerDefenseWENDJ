import java.awt.image.BufferedImage;

/**
 * Created by dmitry_ilin on 6/12/17.
 */
public class BananaBomb extends Tower {

    private int x, y;
    private BufferedImage pic;

    public BananaBomb(int x, int y, BufferedImage pic){
        super(x, y, pic, 5);
        this.x = x;
        this.y = y;
        this.pic = pic;
        setPic("Banana Peel.png");

    }




}
