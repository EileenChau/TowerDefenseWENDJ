import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by samuel_wolff on 6/2/17.
 */
// I think this will be the mario Tower
public class SimpleTower extends Tower {
    int x2,y2, radius, range;
    BufferedImage pic;
    public SimpleTower(int x, int y, BufferedImage image, int r){
        super(x,y,image,r);
        x2=x;
        y2=y;
        pic=image;
        radius=r;
        range=r;
        this.setPic("MarioP.png");
        //        this.setPro();
        this.setRange(100);

    }
    public void Shoot(ArrayList<Projectile> bullets){
        pro.setLoc(new Point(x2,y2));
        bullets.add(pro);
    }
    public void draw(Graphics2D g2){
        g2.drawImage(pic,x2,y2,pic.getWidth(),pic.getHeight(),null);
    }

}
