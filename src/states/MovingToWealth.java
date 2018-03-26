package states;

import zofia.Zofia;

/**
 * Created by Sam Man on 3/24/2018.
 */
public class MovingToWealth extends State {
    @Override
    public void act(Zofia zofia) {
        zofia.recharge();
        System.out.println("Zofia is at Wealth");
        super.changeState(zofia);
    }
}
