/**
 * Created by eileen_chau on 6/13/17.
 */
public class BlackShroom extends Enemy {

    public BlackShroom(Tile[][] arr){
        super(arr);
        setPic("GreenShroom.png", NORTH);
        setHealth(7);
        setSpeed(7);
    }
}
