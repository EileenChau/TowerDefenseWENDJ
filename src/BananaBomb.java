import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by dmitry_ilin on 6/12/17.
 */
public class BananaBomb extends Tower {
    public BananaBomb(int x, int y, BufferedImage pic){
        super(x, y, pic, 5, 20);
        setPic("Banana Peel.png");

    }
    @Override
    public boolean check(int x, int y, Tile[][] tiles) {
        Tile spot = tiles[((y+31) / 50)][((x+31) / 50)];
        if (spot instanceof WaterTile || spot instanceof RoadTile) {
            return true;
        }
        return false;
    }

}
