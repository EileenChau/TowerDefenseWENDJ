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

    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(color);
        g2.fillRect(x, y, size, size);

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
