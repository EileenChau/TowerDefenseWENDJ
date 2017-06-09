import java.awt.*;

/**
 * Created by eileen_chau on 6/1/17.
 */
public class WaterTile extends Tile{

    public WaterTile(int x, int y, int size){
        super(x, y, size, 90);
        setPic("Water.png");
    }
}
