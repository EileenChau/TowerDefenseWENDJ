/**
 * Created by eileen_chau on 6/13/17.
 */
public class SpikedShell extends Enemy{

    public SpikedShell(Tile[][] arr){
        super(arr);
        setPic("SpikedShell.png", NORTH);
        setHealth(1000);
        setSpeed(10);
    }
}
