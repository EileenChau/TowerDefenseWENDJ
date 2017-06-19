import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by samuel_wolff on 6/19/17.
 */
public class DonkeyKong extends Tower {
    ArrayList<WaterBomb> pop=new ArrayList<WaterBomb>();
    BufferedImage wat;
    private int shootNum;
    private int price;
    public DonkeyKong(int x, int y, BufferedImage pic, int r, int p) {
        super(x, y, pic, r, p);
        wat=pic;
        setRange(r);
        price =p;
        this.setShootnum(10);
        this.setPic("Donkey Kong.png");
        //this.setPic("MarioP.png");
        //        this.setPro();
        this.setRange(300);
        try {
            wat= ImageIO.read(new File("res/Barrel.png" ));
        } catch (Exception e) {
            e.printStackTrace();
        }

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
            Barrel p = new Barrel(getX2(),getY2(),0,0, en);
            //p.setDir(p.getDirection(new Point(x2,y2),en.getLoc()));
            pr.add(p);
        }

    }
}
