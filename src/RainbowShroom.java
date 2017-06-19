/**
 * Created by eileen_chau on 6/13/17.
 */
public class RainbowShroom extends Enemy{

    public RainbowShroom(Tile[][] arr){
        super(arr);
        setPic("RainbowShroom.png", NORTH);
        setHealth(700);
        setSpeed(8);
    }
}
