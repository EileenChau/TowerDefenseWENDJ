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

    private int mousex,mousey;
    private Color play = new Color(0,0,0);


    public Main() {
        setSize(FRAMEWIDTH, FRAMEHEIGHT);
        tiles = new Tile[32][32];
        int rand = (int) Math.random() * 32;
        tiles[0][rand] = new RoadTile(0, rand*25);
        int i = 1;
        while(i < 32){
            int rand1 = (int) Math.random() * 32;
            if(tiles[i][rand-1] != null || tiles[i][rand+1] != null || tiles[i-1][rand] != null) {
                tiles[i][rand] = new RoadTile(i * 25, rand1 * 25);
                i++;
            }
        }



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
