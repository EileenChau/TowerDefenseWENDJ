import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.ArrayList;

/**
 * Created by eileen_chau on 6/14/17.
 */
public class Kirby extends Tower {
    public Kirby(int x, int y, BufferedImage pic, int r){
        super(x,y,pic,r, 20);
        setShootnum(0);
        setPic("Kirby.png");
        //        this.setPro();
        setRange(300);
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
            AirBoomarang p = new AirBoomarang(getX2(),getY2(),0,en);
            //p.setDir(p.getDirection(new Point(x2,y2),en.getLoc()));
            pr.add(p);
        }

    }
}
