import javax.swing.*;

/**
 * Created by eileen_chau on 5/31/17.
 */
public class Main extends JPanel{
    public static final int FRAMEWIDTH = 1000, FRAMEHEIGHT = 600;
    public Tile[][] tiles;
    public Enemy enemy;
    public World world;

    public Main(){
        setSize(FRAMEWIDTH, FRAMEHEIGHT);
        tiles = new Tile[32][32];
        enemy = new Enemy(getWidth()/2, 15, Sprite.SOUTH, world);
        for(Enemy e: enemy){
            if(e.intersects(que)){

            }
        }
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Tower Defense");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, FRAMEWIDTH, FRAMEHEIGHT + 22); //(x, y, w, h) 22 due to title bar.

        Main panel = new Main();
        panel.setSize(FRAMEWIDTH, FRAMEHEIGHT);

        panel.setFocusable(true);
        panel.grabFocus();

        window.add(panel);
        window.setVisible(true);
        window.setResizable(false);

    }
}
