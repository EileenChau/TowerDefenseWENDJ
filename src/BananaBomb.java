import java.awt.image.BufferedImage;

/**
 * Created by dmitry_ilin on 6/12/17.
 */
public class BananaBomb extends Tower {



    public BananaBomb(int x, int y, BufferedImage pic, int r, int p){
        super(x, y, pic, r, p);

        this.pic = pic;
        this.radius = r;
        setPic("Banana Peel.png");

    }
    @Override
    public boolean check(int x, int y, Tile[][] tiles) {
        int sx=x2/50;
        int sy=y2/50;
        Tile spot = tiles[((y2+31) / 50)][((x2+31) / 50)];

        if (spot instanceof RoadTile) {
            return true;
        }
        return false;
    }

    public boolean hit(Enemy e){
        if(this.getdistance(e.getLoc().x, e.getLoc().y) <= radius){
            System.out.println("HIT");
            return true;

        }
        return false;
    }

}
