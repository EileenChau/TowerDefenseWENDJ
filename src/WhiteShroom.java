/**
 * Created by eileen_chau on 6/13/17.
 */
public class WhiteShroom extends Enemy{

    public WhiteShroom(Tile[][] arr){
        super(arr);
        setPic("WhiteShroom.png", NORTH);
        setHealth(6);
        setSpeed(7);
    }
}
