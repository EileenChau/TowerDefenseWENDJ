import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;


/**
 * Created by natalie_hsu on 6/1/17.
 */
public class Enemy extends Sprite{
    private int health;
    private Tile[][] array;
    private int rM, cM, lastR;
    private Point p;

    public Enemy(int dir, Tile[][] arr){
        super(0, 7*50, dir);
        array = arr;
        rM = 7;
        cM = 0;
        lastR = 0;
        setPic("RedShroom.png", NORTH);
        health = 1;
        p = new Point(0, 0);
    }

    public int getHealth() {
        return health;
    }

    public void update(){
        if (cM < array.length - 1 && array[rM][cM + 1] instanceof RoadTile) {
            lastR = rM;
            p.setLocation((cM+1)*50, rM*50);
            cM++;
        }
        else if (rM < array.length - 1 && array[rM + 1][cM] instanceof RoadTile && rM+1 != lastR) {
            lastR = rM;
            p.setLocation(cM*50, (rM+1) * 50);
            rM++;
        }
        else if (rM > 0 && array[rM - 1][cM] instanceof RoadTile && rM-1 != lastR) {
            lastR = rM;
            p.setLocation(cM*50, (rM-1)*50);
            rM--;
        }
        this.setLoc(p);
    }

    public void setHealth(int h){
        health = h;
    }

    public void draw(Graphics2D g2){
        super.draw(g2);
    }
}
