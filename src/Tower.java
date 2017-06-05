import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by samuel_wolff on 6/1/17.
 */
public class Tower {
    int x2,y2,speed, radius;
    BufferedImage pic;
    public Tower(int x, int y,int projectileSpeed, BufferedImage image, int r){
        x2=x;
        y2=y;
        speed=projectileSpeed;
        pic=image;
        radius=r;
    }
    public double getdistance(int otherX,int otherY){
        double one= Math.abs(otherX-x2);
        double two=Math.abs(otherY-y2);
        return Math.sqrt((one*one)+(two*two));
    }
    public void draw(Graphics2D g2){
        g2.drawImage(pic,x2,y2,pic.getWidth(),pic.getHeight(),null);
    }
    public boolean check(int x, int y){
        if (getdistance(x,y)>radius){
            return true;
        }
            return false;


    }
    public void Shoot(ArrayList <Projectile> projectiles){

    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public int getSpeed() {
        return speed;
    }

    public int getRadius() {
        return radius;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
