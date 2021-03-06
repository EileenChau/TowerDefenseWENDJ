import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by eileen_chau on 6/14/17.
 */
public class Pikachu extends Tower {
    public Pikachu(int x, int y, BufferedImage pic){
        super(x,y,pic,300,20);
        setPic("Pikachu.png");
        //        this.setPro();
        setRange(300);
    }

    public void shoot(ArrayList<Enemy> enemies, ArrayList<Projectile> bullets) {
        Enemy en;
        double[] dists = new double[enemies.size()];
        int count = 0;
        int index = -1;
        double least = -1;
        for (Enemy e : enemies) {
            dists[count] = this.getdistance(e.getLoc().x, e.getLoc().y);
            count++;
        }
        for (int i = 0; i < dists.length; i++) {
            if (i == 0) {
                if (dists[i] < getRadius()) {
                    least = dists[i];
                    index = i;
//                    System.out.println("ye");
                }
            } else {
                if (dists[i] < least) {
                    least = dists[i];
                    index = i;
                }

            }
        }
        if (least != -1) {
            en = enemies.get(index);
            LightningBolt p = new LightningBolt(getX2(), getY2(), 0, en);
            //p.setDir(p.getDirection(new Point(x2,y2),en.getLoc()));
            bullets.add(p);
        }
    }
}
