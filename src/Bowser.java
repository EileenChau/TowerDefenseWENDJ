/**
 * Created by eileen_chau on 6/13/17.
 */
public class Bowser extends Enemy{

    public Bowser(Tile[][] arr){
        super(arr);
        setPic("Bowser.png", NORTH);
        setHealth(100);
        setSpeed(3);
    }
}
