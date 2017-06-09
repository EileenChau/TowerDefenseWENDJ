import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by eileen_chau on 6/1/17.
 */
public class Tile {

    private int x, y, size, picOrientation, dir;
    private BufferedImage pic;
    public static final int NORTH = 90, SOUTH = 270, WEST = 180, EAST = 0;

    public Tile(int xx, int yy, int s, int pO){
        x = xx;
        y = yy;
        size = s;
        dir = NORTH;
        picOrientation = pO;
        setPic("MarioA.png");
    }


    public void setPic(String filename){
        try {
            pic = ImageIO.read(new File("res/" + filename));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        double rotationRequired = Math.toRadians(picOrientation - dir);
        double locationX = pic.getWidth() / 2;
        double locationY = pic.getHeight() / 2;
        AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        g2.drawImage(op.filter(pic, null), x, y, null);

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize(){
        return size;
    }
}
