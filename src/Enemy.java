import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;


/**
 * Created by natalie_hsu on 6/1/17.
 */
public class Enemy extends Sprite{
    private Point p;
    private int health;
    public Enemy(int dir){
        super(0, 7*50, dir);
        setPic("RedShroom.png", NORTH);
        p = new Point(0, 7*50);
        setSpeed(5);
        health = 1;
    }

    public Point getP() {
        return p;
    }

    public void setHealth(int h){
        health = h;
    }

    public void setLoc(Point pp){
        p = pp;
    }

    public void draw(Graphics2D g2){
        super.draw(g2);
    }
}
