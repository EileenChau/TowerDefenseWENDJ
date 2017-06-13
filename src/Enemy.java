import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;


/**
 * Created by natalie_hsu on 6/1/17.
 */
public class Enemy extends Sprite{
    private int health;
    private Tile[][] array;
    private int rM, cM;

    public Enemy(Tile[][] arr){
        super(0, 7*50, Sprite.EAST);
        array = arr;
        rM = 7;
        cM = 0;
        setPic("RedShroom.png", NORTH);
        health = 1;
    }

    public void update(){
        super.update();
        if (cM < array.length - 1 && array[rM][cM+1] instanceof RoadTile) {
            this.setDir(EAST);
            if(this.getLoc().getX() >= (cM+1)*50) {
                cM++;
            }
        }
        else if (rM < array.length - 1 && array[rM+1][cM] instanceof RoadTile && this.getDir() != NORTH) {
            this.setDir(SOUTH);
            if(this.getLoc().getY() >= (rM+1)*50) {
                rM++;
            }
        }
        else if (rM > 0 && array[rM-1][cM] instanceof RoadTile && this.getDir() != SOUTH) {
            this.setDir(NORTH);
            if(this.getLoc().getY() <= (rM-1)*50) {
                rM--;
            }
        }
    }

    public void draw(Graphics2D g2){
        g2.drawImage(this.getPic(), this.getLoc().x, this.getLoc().y, null);

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int h){
        health = h;
    }

    public void moveBack(int tile){

    }
}
