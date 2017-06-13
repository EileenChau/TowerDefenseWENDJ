import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;


/**
 * Created by eileen_chau on 5/31/17.
 */
public class Main extends JPanel{
    public static final int FRAMEWIDTH = 1000, FRAMEHEIGHT = 800;
    private Tile[][] tiles;
    private ArrayList<Projectile> pro= new ArrayList<>();
    private ArrayList<Projectile> copy= new ArrayList<>();
    private BufferedImage[][] pics = new BufferedImage[7][2];
    private Timer timer;
    private ArrayList<Enemy> enemy;
    private boolean car;
    private Tower carried;
    private BufferedImage carr;
    private ArrayList<Tower> towers= new ArrayList<>();
    private int screen = 0;
    private int size = 50;
    private int count, maxCount;
    private int money, health;


    private int mousex,mousey;
    private Color play = new Color(0,0,0);


    public Main() {
        setSize(FRAMEWIDTH, FRAMEHEIGHT);
        tiles = new Tile[16][16];
        try {
            pics[0][0] = ImageIO.read(new File("res/Mario.png" ));
            pics[0][1] = ImageIO.read(new File("res/Donkey Kong.png" ));
            pics[1][0] = ImageIO.read(new File("res/Pikachu.png" ));
            pics[1][1] = ImageIO.read(new File("res/Squirtle.png" ));
            pics[2][0] = ImageIO.read(new File("res/Yoshi.png" ));
            pics[2][1] = ImageIO.read(new File("res/Banana Peel.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }// Pic Maker
        makeMap();
        enemy = new ArrayList<>();
        count = 1;
        maxCount = 100;
        money = 200;
        health = 10;
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                System.out.println(e.getX() + " " + e.getY());
                if(screen==0) {
                    if (mousex > 335 && mousex < 435 && mousey > 260 && mousey < 315) {
                        screen = 1;
                    }
                }
                if(car){
                    if(mousex>800){
                        car=false;
                    }
                    else{
                        carried.setX2(mousex-15);
                        carried.setY2(mousey-15);
                        if(carried.check(mousex-15,mousey-15,tiles)){
                            towers.add(carried);
                            car=false;
                        }

                    }
                }
                if(!car) {
                    if (screen == 1) {
                        if (mousex > 810 && mousex < 890 && mousey > 28 && mousey < 95) {
                            carr=pics[0][0];
                            carried=new SimpleTower(mousex,mousey,pics[0][0],62);
                            car = true;
                        }
                        if (mousex > 910 && mousex < 990 && mousey > 28 && mousey < 95) {
                            carr=pics[0][1];
                            carried=new Tower(mousex,mousey,pics[0][1],62);
                            car = true;
                        }
                        if (mousex > 810 && mousex < 890 && mousey > 105 && mousey < 180) {
                            carr=pics[1][0];
                            carried=new Tower(mousex,mousey,pics[1][0],62);
                            car = true;
                        }
                        if (mousex > 910 && mousex < 990 && mousey > 105 && mousey < 180) {
                            carr=pics[1][1];
                            carried=new Squirtle(mousex,mousey,pics[1][1],62);
                            car = true;
                        }
                        if (mousex > 810 && mousex < 890 && mousey > 190 && mousey < 265) {
                            carr=pics[2][0];
                            carried=new Tower(mousex,mousey,pics[2][0],62);
                            car = true;
                        }
                        if (mousex > 910 && mousex < 990 && mousey > 190 && mousey < 265) {
                            carr=pics[2][1];
                            carried=new Tower(mousex,mousey,pics[2][1],62);
                            car = true;
                        }
                    }
                }//Side Menu Stuff


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

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped (KeyEvent e){
                int code = e.getKeyChar();
                if (code == 'r') {
                    makeMap();
                }
                if (code == 'p') {
                    timer.stop();
                }
            }

            @Override
            public void keyPressed (KeyEvent e){

            }

            @Override
            public void keyReleased (KeyEvent e){

            }
        });

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

        timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                for (Tower t: towers) {
                    if (t instanceof Squirtle) {
                        if (t.Shootable()) {
                            ((Squirtle) t).shoot(enemy, pro);
                        }
                    }
                }
                        for (Projectile p: pro){
                            for (Enemy e: enemy){
                                if(e.intersects(p));
                                e.setHealth(e.getHealth()-100);
                            }
                        }
                for (int i = 0; i < pro.size(); i++) {
                    for (int j = 0; j <enemy.size() ; j++) {
                        if(pro.get(i).intersects(enemy.get(j))){
                            pro.remove(i);
                        }

                    }

                }


//                for (Enemy e: enemy){
//                    if(e.getHealth()<1){
//                        enemy.remove(e);
//                    }
//                }
                count++;
                if(count > maxCount) {
                    int rand = (int)(Math.random()*2);
                    if(rand == 0) {
                        enemy.add(new Enemy(tiles));
                    }
                    else {
                        enemy.add(new BlueShroom(tiles));
                    }
                    count = 0;
                }
                for (int i = 0; i < enemy.size(); i++) {
                    enemy.get(i).update();
                    if(enemy.get(i).getLoc().x >= 1000){
                        health -= enemy.get(i).getHealth();
                        enemy.remove(i);
                        i--;
                    }
                }

             repaint();
            }
        });
        timer.start();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        //super.paint(g2);
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                tiles[i][j].draw(g2);
            }
        }

        if(enemy.size()>0) {
            for (Enemy e : enemy) {
                e.draw(g2);
            }
        }
        g2.setColor(new Color(172, 116, 30));
        g2.fillRect(800,0,200,800);
        g2.setColor(Color.WHITE);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 2; j++) {
                g2.fillRect(810+(j*90),25+(i*90),75,75);
            }
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 2; j++) {
                g2.drawImage(pics[i][j],810+(j*90),25+(i*90),null);
            }
        }
        if(car){
            g2.drawImage(carr,mousex-20,mousey-20,null);
        }
        for(Projectile p: pro){
            p.draw(g2);
            p.update();
        }
        for (Tower t: towers){
            t.draw(g2);
        }

        if(health == 0){
            timer.stop();
            g2.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
            g2.setColor(Color.black);
            g2.drawString("Game Over", getWidth() / 3, 200);
        }

        if(screen==0) {
            if (mousex > 335 && mousex < 435 && mousey > 260 && mousey < 315) {
                play = Color.WHITE;
            } else {
                play = Color.black;
            }

            g2.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
            g2.setColor(Color.black);
            g2.drawString("Tower Defense", getWidth() / 3, 200);
            g2.setColor(play);
            g2.drawString("Play", getWidth() / 3, 300);
        }//Main Menu
    }

    public void makeMap(){
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                tiles[i][j] = null;
            }
        }
        int r = 7;
        int c = 0;
        tiles[r][c] = new RoadTile(c, r*size);
        while(c < tiles.length-1){
            int dir = (int)(Math.random()*3);
            if(dir == 0){
                if(r < tiles.length-1 && tiles[r+1][c] == null) {
                    tiles[r+1][c] = new RoadTile(c*size, (r+1)*size);
                    r++;
                }
            }
            if(dir == 1){
                if(r != 0 && tiles[r-1][c] == null) {
                    tiles[r-1][c] = new RoadTile(c*size, (r-1)*size);
                    r--;
                }
            }
            if(dir == 2){
                if(c < tiles.length-1) {
                    c++;
                    tiles[r][c] = new RoadTile(c*size, r*size);
                    if(c < tiles.length-1) {
                        c++;
                        tiles[r][c] = new RoadTile(c*size, r*size);
                    }
                }
            }
        }

        int randWater = (int)(Math.random() * 4);
        for (int j = 0; j < randWater; j++) {
            int randR = (int)(Math.random() * tiles.length);
            int randC = (int)(Math.random() * tiles.length);
            if(tiles[randR][randC] == null){
                tiles[randR][randC] = new WaterTile(randC*size, randR*size);
                if(randC < tiles.length-1 && tiles[randR][randC+1] == null) {
                    tiles[randR][randC+1] = new WaterTile((randC+1)*size, randR*size);
                }
                if(randC > 0 && tiles[randR][randC-1] == null){
                    tiles[randR][randC-1] = new WaterTile((randC-1)*size, randR*size);
                }
                if(randR < tiles.length-1 && tiles[randR+1][randC] == null){
                    tiles[randR+1][randC] = new WaterTile(randC*size, (randR+1)*size);
                }
                if(randR > 0 && tiles[randR-1][randC] == null){
                    tiles[randR-1][randC] = new WaterTile(randC*size, (randR-1)*size);
                }
                if(randR < tiles.length-1 && randC < tiles.length-1 && tiles[randR+1][randC+1] == null){
                    tiles[randR+1][randC+1] = new WaterTile((randC+1)*size, (randR+1)*size);
                }
                if(randR < tiles.length-1 && randC > 0 && tiles[randR+1][randC-1] == null){
                    tiles[randR+1][randC-1] = new WaterTile((randC-1)*size, (randR+1)*size);
                }
                if(randR > 0 && randC > 0 && tiles[randR-1][randC-1] == null){
                    tiles[randR-1][randC-1] = new WaterTile((randC-1)*size, (randR-1)*size);
                }
                if(randR > 0 && randC < tiles.length-1 && tiles[randR-1][randC+1] == null){
                    tiles[randR-1][randC+1] = new WaterTile((randC+1)*size, (randR-1)*size);
                }
            }
        }

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if(tiles[i][j] == null){
                    tiles[i][j] = new LandTile(j*size, i*size);
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
