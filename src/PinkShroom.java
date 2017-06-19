/**
 * Created by eileen_chau on 6/13/17.
 */
public class PinkShroom extends Enemy{

    public PinkShroom(Tile[][] arr){
        super(arr);
        setPic("PinkShroom.png", NORTH);
        setHealth(130);
        setSpeed(6);
    }
}
