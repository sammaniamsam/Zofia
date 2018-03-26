package states;

import zofia.Zofia;

/**
 * Created by Sam Man on 3/24/2018.
 */
public class MovingToFlag extends State{
    @Override
    public void act(Zofia zofia) {
        System.out.println("Zofia is at Flag");
        super.changeState(zofia);
    }
}
