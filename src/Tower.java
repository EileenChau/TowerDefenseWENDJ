import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by samuel_wolff on 6/1/17.
 */
public class Tower {
    int x2, y2, radius, range;
    BufferedImage pic;
    Projectile pro;
    int shootnum;
    int shootCount=1;
    int price;

    public Tower(int x, int y, BufferedImage pic, int r, int p) {
        x2 = x;
        y2 = y;
        setPic("Mario.png");
        radius = r;
        range = r;
        price = p;
    }

    public void setShootnum(int shootnum) {
        this.shootnum = shootnum;
    }

    public double getdistance(int otherX, int otherY) {
        double one = Math.abs(otherX - x2);
        double two = Math.abs(otherY - y2);
        return Math.sqrt((one * one) + (two * two));
    }
    public boolean Shootable(){
        if(shootnum%shootCount==0){
            shootCount++;
            return true;
        }
        else {
            shootCount++;
            return false;
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(pic, x2, y2, pic.getWidth(), pic.getHeight(), null);
    }

    public boolean check(int x, int y, Tile[][] tiles) {
        Tile spot = tiles[((y+31) / 50)][((x+31) / 50)];
        if (spot instanceof WaterTile || spot instanceof RoadTile) {
            return false;
        }
        return true;

    }

    public BufferedImage getPic() {
        return pic;
    }

    public void setPic(String fileName) {
        try {
            pic = ImageIO.read(new File("res/" + fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Projectile getPro() {
        return pro;
    }

    public void setPro(Projectile pro) {
        this.pro = pro;
    }

    public void Shoot(ArrayList <Projectile> projectiles){

    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public int getPrice(){
        return price;
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

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}

