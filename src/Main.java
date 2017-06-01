import javax.swing.*;

/**
 * Created by eileen_chau on 5/31/17.
 */
public class Main extends JPanel{
    public static final int FRAMEWIDTH = 1000, FRAMEHEIGHT = 600;
    public Tile[][] tiles;

    public Main(){
        setSize(FRAMEWIDTH, FRAMEHEIGHT);
        tiles = new Tile[32][32];
        int i = 0;
        while(i < 32){
            int rand = (int) Math.random() * 32;
            tiles[i][rand] = new RoadTile(i*25, rand*25);
            i++;
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
