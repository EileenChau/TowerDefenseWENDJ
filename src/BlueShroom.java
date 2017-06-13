/**
 * Created by eileen_chau on 6/12/17.
 */
public class BlueShroom extends Enemy{

    public BlueShroom(Tile[][] arr){
        super(arr);
        setPic("BlueShroom.png", NORTH);
        setHealth(2);
    }
}
