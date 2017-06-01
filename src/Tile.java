import java.awt.*;

/**
 * Created by eileen_chau on 6/1/17.
 */
public class Tile {

    private Color color;
    private int x, y;

    public Tile(int xx, int yy, Color c){
        x = xx;
        y = yy;
        color = c;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor(){
        return color;
    }
}
