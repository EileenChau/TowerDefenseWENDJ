import java.awt.*;

/**
 * Created by eileen_chau on 6/1/17.
 */
public class Tile {

    private Color color;
    private int x, y, size;

    public Tile(int xx, int yy, Color c, int s){
        x = xx;
        y = yy;
        color = c;
        size = s;
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

    public int getSize(){
        return size;
    }
}
