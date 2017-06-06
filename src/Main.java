import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * Created by eileen_chau on 5/31/17.
 */
public class Main extends JPanel{
    public static final int FRAMEWIDTH = 1000, FRAMEHEIGHT = 800;
    public Tile[][] tiles;
    private Timer timer;
    private int screen = 0;
    int size = 50;

    private int mousex,mousey;
    private Color play = new Color(0,0,0);


    public Main() {
        setSize(FRAMEWIDTH, FRAMEHEIGHT);
        tiles = new Tile[16][16];
        makeMap();

        timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        //System.out.println(e.getX() + " " + e.getY());
                        if(screen==0) {
                            if (mousex > 335 && mousex < 435 && mousey > 260 && mousey < 315) {
                                screen = 1;
                            }
                        }

                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }

                });

                KeyListener keyListener = new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                };
                addMouseMotionListener(new MouseMotionListener() {
                    @Override
                    public void mouseDragged(MouseEvent e) {

                    }

                    @Override
                    public void mouseMoved(MouseEvent e) {
                        mousey=e.getY();
                        mousex=e.getX();
                    }
                });

             repaint();
            }
        });
        timer.start();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                tiles[i][j].draw(g2);
            }
        }
        if(screen==0) {

            if (mousex > 335 && mousex < 435 && mousey > 260 && mousey < 315) {
                play = Color.WHITE;
            } else {
                play = Color.black;
            }
            g2.setColor(Color.GREEN);
            g2.fillRect(0, 0, getWidth(), getHeight());
            g2.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
            g2.setColor(Color.black);
            g2.drawString("Tower Defense", getWidth() / 3, 200);
            g2.setColor(play);
            g2.drawString("Play", getWidth() / 3, 300);
        }
    }

    public void makeMap(){
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                tiles[i][j] = null;
            }
        }
        int r = 7;
        int c = 0;
        tiles[r][c] = new RoadTile(c, r*size, size);
        while(c < tiles.length-1){
            int dir = (int)(Math.random()*3);
            if(dir == 0){
                if(r < tiles.length-1 && tiles[r+1][c] == null) {
                    tiles[r+1][c] = new RoadTile(c*size, (r+1)*size, size);
                    r++;
                }
            }
            if(dir == 1){
                if(r != 0 && tiles[r-1][c] == null) {
                    tiles[r-1][c] = new RoadTile(c*size, (r-1)*size, size);
                    r--;
                }
            }
            if(dir == 2){
                if(c < tiles.length-1) {
                    c++;
                    tiles[r][c] = new RoadTile(c*size, r*size, size);
                    if(c < tiles.length-1) {
                        c++;
                        tiles[r][c] = new RoadTile(c*size, r*size, size);
                    }
                }
            }
        }

        int randWater = (int)(Math.random() * 4);
        for (int j = 0; j < randWater; j++) {
            int randR = (int)(Math.random() * tiles.length);
            int randC = (int)(Math.random() * tiles.length);
            if(tiles[randR][randC] == null){
                tiles[randR][randC] = new WaterTile(randC*size, randR*size, size);
                if(randC < tiles.length-1 && tiles[randR][randC+1] == null) {
                    tiles[randR][randC+1] = new WaterTile((randC+1)*size, randR*size, size);
                }
                if(randC > 0 && tiles[randR][randC-1] == null){
                    tiles[randR][randC-1] = new WaterTile((randC-1)*size, randR*size, size);
                }
                if(randR < tiles.length-1 && tiles[randR+1][randC] == null){
                    tiles[randR+1][randC] = new WaterTile(randC*size, (randR+1)*size, size);
                }
                if(randR > 0 && tiles[randR-1][randC] == null){
                    tiles[randR-1][randC] = new WaterTile(randC*size, (randR-1)*size, size);
                }
                if(randR < tiles.length-1 && randC != tiles.length && tiles[randR+1][randC+1] == null){
                    tiles[randR+1][randC+1] = new WaterTile((randC+1)*size, (randR+1)*size, size);
                }
                if(randR < tiles.length-1 && randC != 0 && tiles[randR+1][randC-1] == null){
                    tiles[randR+1][randC-1] = new WaterTile((randC-1)*size, (randR+1)*size, size);
                }
                if(randR > 0 && randC != 0 && tiles[randR-1][randC-1] == null){
                    tiles[randR-1][randC-1] = new WaterTile((randC-1)*size, (randR-1)*size, size);
                }
                if(randR > 0 && randC != tiles.length && tiles[randR-1][randC+1] == null){
                    tiles[randR-1][randC+1] = new WaterTile((randC+1)*size, (randR-1)*size, size);
                }
            }
        }

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if(tiles[i][j] == null){
                    tiles[i][j] = new LandTile(j*size, i*size, size);
                }
            }
        }
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Tower Defense");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, FRAMEWIDTH, FRAMEHEIGHT+22); //(x, y, w, h) 22 due to title bar.

        Main panel = new Main();
        panel.setSize(FRAMEWIDTH, FRAMEHEIGHT);

        panel.setFocusable(true);
        panel.grabFocus();

        window.add(panel);
        window.setVisible(true);
        window.setResizable(false);

    }
}
