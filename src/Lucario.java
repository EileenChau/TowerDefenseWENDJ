import java.awt.image.*;
import java.util.ArrayList;

/**
 * Created by samuel_wolff on 6/19/17.
 */
public class Lucario extends Tower {
    public Lucario(int x, int y, BufferedImage pic, int r, int p) {
        super(x, y, pic, r, p);
        this.setPic("Lucario.png");
        this.setShootnum(10);
    }
    public void shoot(ArrayList<Enemy> enemies, ArrayList<Projectile> pr){
        Enemy en;
        double[]dists= new double[enemies.size()];
        int count=0;
        int index=-1;
        double least=-1;
        for(Enemy e: enemies){
            dists[count]=this.getdistance(e.getLoc().x,e.getLoc().y);
            System.out.println(dists[count]);

            count++;
        }
        for (int i = 0; i <dists.length ; i++) {
            if (i==0){
                if(dists[i]<range){
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
            PlasmaBall p = new PlasmaBall(x2,y2,0, en);
            //p.setDir(p.getDirection(new Point(x2,y2),en.getLoc()));
            pr.add(p);
        }

    }
}
