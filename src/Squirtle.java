import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.nio.Buffer;
import java.util.ArrayList;

/**
 * Created by samuel_wolff on 6/10/17.
 */
public class Squirtle extends Tower {
    ArrayList<WaterBomb> pop=new ArrayList<WaterBomb>();
    int shootNum;

    public Squirtle(int x, int y, BufferedImage pic, int r){
        super(x,y,pic,r, 20);
        setPic("Squirtle.png");
        //this.setPic("MarioP.png");
        //        this.setPro();
        setRange(300);
    }
    @Override
    public boolean check(int x, int y, Tile[][] tiles) {
        int sx=x/50;
        int sy=y/50;
        Tile spot = tiles[((y+31) / 50)][((x+31) / 50)];

        if (spot instanceof LandTile || spot instanceof RoadTile) {
            return false;
        }
        return true;
    }

    public ArrayList<WaterBomb> getPop() {
        return pop;
    }

    public void shoot(ArrayList<Enemy> enemies, ArrayList<Projectile> pr){
        Enemy en;
        double[]dists= new double[enemies.size()];
        int count=0;
        int index=-1;
        double least=-1;
        for(Enemy e: enemies){
            dists[count]=this.getdistance(e.getLoc().x,e.getLoc().y);
            count++;
        }
        for (int i = 0; i <dists.length ; i++) {
            if (i==0){
                if(dists[i]<getRange()){
                    least =dists[i];
                    index=i;
                }
            }else {
                if(dists[i]<least){
                    least=dists[i];
                    index=i;
                }

            }
        }
        if(least!=-1){
            en=enemies.get(index);
            WaterBomb p = new WaterBomb(getX2(),getY2(),0,en);
            //p.setDir(p.getDirection(new Point(x2,y2),en.getLoc()));
            pr.add(p);
        }

    }

}
