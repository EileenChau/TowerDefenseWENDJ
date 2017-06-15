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
    int x2,y2, radius, range;
    BufferedImage pic, bul;
    public SimpleTower(int x, int y, BufferedImage image, int r){
        super(x,y,image,r);
        x2=x;
        y2=y;
        pic=image;
        radius=r;
        range=r;
        this.setPic("Mario.png");
        //        this.setPro();
        this.setShootnum(2);
        this.setRange(300);
        try {
            bul= ImageIO.read(new File("res/Mario Fireball.png" ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Shoot(ArrayList<Projectile> bullets,ArrayList<Enemy> enemies){
        Enemy en;
        //System.out.println("this is called on");
        double[]dists= new double[enemies.size()];
        int count=0;
        int index=-1;
        double least=-1;
        for(Enemy e: enemies){
            dists[count]=e.getLoc().distance((double)this.x2,(double)(this.y2));

            count++;
        }
        for (int i = 0; i <dists.length ; i++) {
            System.out.println(range);
            if (i==0) {
                if (dists[i] < range) {
                    least = dists[i];
                    index = i;
                }
            }
            else {
                if(dists[i]<least){
                    least=dists[i];
                    index=i;
                }

            }
        }
        if(index!=-1){
            en=enemies.get(index);
            Fireball p = new Fireball(x2,y2,0, en, bul);
            //p.setDir(p.getDirection(new Point(x2,y2),en.getLoc()));
            bullets.add(p);
            System.out.println("its made");
        }

    }
    public void draw(Graphics2D g2){
        g2.drawImage(pic,x2,y2,pic.getWidth(),pic.getHeight(),null);
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
}
