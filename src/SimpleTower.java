import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by samuel_wolff on 6/2/17.
 */
// I think this will be the mario Tower
public class SimpleTower extends Tower {
    public SimpleTower(int x, int y, BufferedImage image){
        super(x,y,image,300, 20);
        setPic("Mario.png");
        //        this.setPro();
        setShootnum(5);
    }

    public void shoot(ArrayList<Enemy> enemies, ArrayList<Projectile> bullets){
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
//                    System.out.println("ye");
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
            Fireball p = new Fireball(getX2(),getY2(),0,en);
            //p.setDir(p.getDirection(new Point(x2,y2),en.getLoc()));
            bullets.add(p);
        }
    }
}
