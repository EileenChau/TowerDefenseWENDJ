/**
 * Created by eileen_chau on 6/1/17.
 */
public class LandTile extends Tile {

    public LandTile(int x, int y){
        super(x, y, 90);
        int rand = (int) (Math.random() * 2);
        if(rand == 0) {
            setPic("Grass.png");
        }
        else{
            setPic("Grass w- Rocks Tile.png");
        }
    }
}
