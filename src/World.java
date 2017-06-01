/**
 * Created by dmitry_ilin on 6/1/17.
 */
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

/**
 * Version 1.2
 *      Added clicking. When a Sprite is clicked, its onClick is called.
 *          If the click is 2-finger, the Sprite is removed.
 *
 *
 * Version 1.1
 *      adds background (WORKS)
 *      adds method to remove sprites from the world (WORKS)
 *
 * Created by michael_hopps on 1/6/16.
 *
 * A World keeps track of the plane on which the Sprites live.
 * It also is where the list of Sprites resides.
 * All addition of Sprites and removal of Sprites should be done through this class.
 */
public class World {

    private ArrayList<Sprite> sprites;
    private int width, height;
    private BufferedImage background;
    private Rectangle leftSide, rightSide, top, bottom; //for wall hit detection

    public World(int w, int h){
        width = w;
        height = h;
        sprites = new ArrayList<Sprite>();
        leftSide = new Rectangle(-5, -5, 10, height+10);
        rightSide = new Rectangle(width-5, -5, 10, height+10);
        top = new Rectangle(-5, -5, width+10, 10);
        bottom = new Rectangle(-5, height-5, width+10, 10);
    }

    /**
     * Updates each Sprite
     */
    public void updateSprites(){
        for (int i = 0; i < sprites.size(); i++) {
            Sprite sprite = sprites.get(i);
            sprite.update();
        }
    }

    /**
     * Draws each Sprite
     * @param g2
     */
    public void drawSprites(Graphics2D g2){
        if(background != null)
            g2.drawImage(background, 0, 0, null);
//
//        g2.setColor(Color.BLACK);
//        g2.drawRect(0,0,width,height);

        for (int i = 0; i < sprites.size(); i++) {
            sprites.get(i).draw(g2);
        }
//        g2.fill(top);
//        g2.fill(bottom);
//        g2.fill(leftSide);
//        g2.fill(rightSide);
    }


    /**
     * Adds a sprite to the world.
     * @param sprite
     */
    public void addSprite(Sprite sprite){
        sprites.add(sprite);
    }

    public void removeSprite(Sprite sprite){
        for (int i = 0; i < sprites.size(); i++) {
            if(sprites.get(i).equals(sprite)) { //will check the ID of the sprites.
                sprites.remove(i);
                return;
            }
        }
    }

    /**
     * Returns an ArrayList of all the Sprites in the World.
     * @return
     */
    public ArrayList<Sprite> getAllSprites(){
        return sprites;
    }

    public int getDirection(Point from, Point to){
        double dx = to.x - from.x;
        double dy = from.y - to.y;
        int deg =  (int)Math.toDegrees(Math.atan(dy/dx));
        if(to.x < from.x)
            deg += 180;
        return deg;
    }

    public boolean isOnScreen(int x, int y){
        return (x > -1 && x < width && y > -1 && y < height);
    }

    public boolean hitLeftSide(Sprite spr){
        Rectangle spriteBox = spr.getBoundingRectangle();
        if(spriteBox.intersects(leftSide))
            return true;
        return false;
    }
    public boolean hitRightSide(Sprite spr){
        Rectangle spriteBox = spr.getBoundingRectangle();
        if(spriteBox.intersects(rightSide))
            return true;
        return false;
    }
    public boolean hitTop(Sprite spr){
        Rectangle spriteBox = spr.getBoundingRectangle();
        if(spriteBox.intersects(top))
            return true;
        return false;
    }
    public boolean hitBottom(Sprite spr){
        Rectangle spriteBox = spr.getBoundingRectangle();
        if(spriteBox.intersects(bottom))
            return true;
        return false;
    }

    public void setBackground(String fileName){
        try{
            background = ImageIO.read(new File("res/" + fileName));
            background = (BufferedImage)background.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        }catch(Exception e){e.printStackTrace();}
    }

    public void click(MouseEvent mouseEvent){
        for(int i = 0; i < sprites.size(); i++){
            Sprite s = sprites.get(i);
            if(s.getBoundingRectangle().contains(mouseEvent.getPoint())) {
                s.onClick();
                if (mouseEvent.getButton() == MouseEvent.BUTTON3)
                    removeSprite(s);
                i = sprites.size();
            }
        }
    }

}

