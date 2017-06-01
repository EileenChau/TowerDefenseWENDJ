import java.awt.*;
import java.io.File;

/**
 * Created by samuel_wolff on 6/1/17.
 */
public class Tower {
    int x2,y2,speed;
    File pic;
    public Tower(int x, int y,int projectileSpeed, File image){
        x2=x;
        y2=y;
        speed=projectileSpeed;
        pic=image;
    }
    public double getdistance(int otherX,int otherY){
        double one= Math.abs(otherX-x2);
        double two=Math.abs(otherY-y2);
        double distance= Math.sqrt((one*one)+(two*two));
        return distance;
    }
    public void draw(Graphics2D g2){
//        g2.drawImage(pic,x2,y2);
    }
}
