/**
 * Created by dmitry_ilin on 6/1/17.
 */
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;


public class Sprite {

    private static int nextID = 1;

    private Point loc; //top left corner of this Sprite. Note loc.x and loc.y are the easy way to access the point.
    private int dir, picOrientation; //dir is the current direction in degrees.  See the constants below.
    private BufferedImage pic; //put the file in the res folder.
    private World myWorld; //the world this sprite exists in!
    private int speed; //Number of pixels moved each frame.
    private int id;
    public static final int NORTH = 90, SOUTH = 270, WEST = 180, EAST = 0, NE = 45, NW = 135, SW = 225, SE = 315;

    //Constructors.
    public Sprite(World world) {
        loc = new Point(0, 0);
        dir = EAST;
        setPic("MarioA.png", NORTH);
        myWorld = world;
        speed = 5;

        id = nextID;
        nextID++;
    }

    public Sprite(int x, int y, int direction) {
        loc = new Point(x, y);
        dir = direction;
        setPic("Boi.png", NORTH);
        //myWorld = world;
        speed = 10;

        id = nextID;
        nextID++;
    }

    /**
     * This draws the image pic at the Point loc, rotated to face dir.
     */
    public void draw(Graphics2D g2) {
        double rotationRequired = Math.toRadians(picOrientation - dir);
        double locationX = pic.getWidth() / 2;
        double locationY = pic.getHeight() / 2;
        AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        g2.drawImage(op.filter(pic, null), loc.x, loc.y, null);
    }

    /**
     * Moves the pic in the direction the Sprite is facing (dir).
     */
    public void update() {
        int dx = (int) (Math.cos(Math.toRadians(dir)) * speed);
        int dy = -(int) (Math.sin(Math.toRadians(dir)) * speed);
        loc.translate(dx, dy);
    }

    /**
     * Changes the image file that this Sprite uses to draw.
     *
     * @param fileName    the case-sensitive file name
     * @param orientation the direction that the image file is facing
     */
    public void setPic(String fileName, int orientation) {
        try {
            pic = ImageIO.read(new File("res/" + fileName));
            picOrientation = orientation;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Changes the direction the Sprite is facing by the given angle.
     *
     * @param delta change in angle measured in degrees
     */
    public void rotateBy(int delta) {
        setDir(dir + delta);
    }

    /**
     * Changes the direction the Sprite is facing to the given angle.
     *
     * @param newDir the new direction measured in degrees
     */
    public void setDir(int newDir) {
        dir = newDir;
    }

    /**
     * Returns a Rectangle object that surrounds this Sprite's pic.
     * Useful for hit detection.
     *
     * @return the bounding Rectangle.
     */
    public Rectangle getBoundingRectangle() {
        return new Rectangle(loc.x, loc.y, pic.getWidth(), pic.getHeight());
    }

    /**
     * Returns the location of this Sprite.
     *
     * @return A point object.  Use p.x and p.y or p.getX() and p.getY()
     */
    public Point getLoc() {
        return loc;
    }

    /**
     * Changes the location of this Sprite.
     *
     * @param loc
     */
    public void setLoc(Point loc) {
        this.loc = loc;
    }

    /**
     * @return the direction the Sprite is facing.  See the constants for reference.
     */
    public int getDir() {
        return dir;
    }
    public int getDirection(Point from, Point to){
        double dx = to.x - from.x;
        double dy = from.y - to.x;
        int deg = (int)Math.toDegrees(Math.atan(dy/dx));
        if(to.x < from.x)
            deg += 180;
        return deg;
    }

    public BufferedImage getPic() {
        return pic;
    }

    public void setPic(BufferedImage pic) {
        this.pic = pic;
    }


    /**
     *Returns the world in which this sprite lives.
     */
    public World getWorld() {
        return myWorld;
    }

    /**
     *Changes the world in which this sprite lives.
     */
    public void setMyWorld(World myWorld) {
        this.myWorld = myWorld;
    }

    /**
     * Returns true if this Sprite is facing East, not true EAST, but EAST at all.
     *
     * @return Returns true if this Sprite is facing East, not true EAST, but EAST at all.
     */
    public boolean facingEast() {
        return dir % 360 < 90 || dir % 360 > 270;
    }

    /**
     * @return Returns true if this Sprite is facing NORTH, not true NORTH, but NORTH at all.
     */
    public boolean facingNorth() {
        return dir % 360 > 0 && dir % 360 < 180;
    }

    /**
     * @return Returns true if this Sprite is facing WEST, not true WEST, but WEST at all.
     */
    public boolean facingWest() {
        return dir % 360 > 90 && dir % 360 < 270;
    }

    /**
     * @return Returns true if this Sprite is facing SOUTH, not true SOUTH, but SOUTH at all.
     */
    public boolean facingSouth() {
        return dir % 360 > 180;
    }

    public int getID() {
        return id;
    }

    /**
     * Overrides the equals method.
     *
     * @param o should be a Sprite
     * @return true if the sprites share the same ID
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Sprite)) //if not a Sprite...false
            return false;
        Sprite other = (Sprite) o;  //cast Object to Sprite variable
        if (other.getID() == getID())    //if ID's match...
            return true;
        return false;
    }

    /**
     * Called by World if the user clicks on this Sprite.
     */
    public void onClick() {
        System.out.println("Clicked on Sprite " + getID());
    }

    /**
     Returns the center of this Sprite
     */
    public Point getCenterPoint(){
        return new Point(loc.x + pic.getWidth()/2, loc.y + pic.getHeight()/2);
    }

    /**
     Returns true if this Sprite intersects the other Sprite
     */
    public boolean intersects(Sprite other){
        return getBoundingRectangle().intersects(other.getBoundingRectangle());
    }

    /**
     Changes the speed of this Sprite
     */
    public void setSpeed(int newSpeed){
        speed = newSpeed;
    }

    /**
     Returns the current speed of this Sprite
     */
    public int getSpeed() {
        return speed;
    }

    public void remove(){

    }
}
