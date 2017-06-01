import java.awt.*;


/**
 * Created by natalie_hsu on 6/1/17.
 */
public class Enemy extends Sprite{
    private Point p;
    private Tile t;
    public Enemy(int x, int y, int dir){
        super(x, y, dir);
        setPic("balloon.png", NORTH);
        p = new Point(x, y);
    }

    public Point getP() {
        return p;
    }

}
