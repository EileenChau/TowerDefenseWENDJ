/**
 * Created by eileen_chau on 6/13/17.
 */
public class GreenShroom extends Enemy{

    public GreenShroom(Tile[][] arr){
        super(arr);
        setPic("GreenShroom.png", NORTH);
        setHealth(3);
    }
}
