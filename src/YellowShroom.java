/**
 * Created by eileen_chau on 6/13/17.
 */
public class YellowShroom extends Enemy{

    public YellowShroom(Tile[][] arr){
        super(arr);
        setPic("YellowShroom.png", NORTH);
        setHealth(5);
    }
}
