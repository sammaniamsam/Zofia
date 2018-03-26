package states;

import zofia.Zofia;

/**
 * Created by Sam Man on 3/24/2018.
 */
public abstract class State {
    public abstract void act(Zofia zofia);
    protected void changeState(Zofia zofia) {
        if(zofia.isAtFlag()) {
            System.out.println("Zofia is moving to the flag");
            zofia.setState(new MovingToFlag());
        } else if (zofia.isAtHealthResource()) {
            System.out.println("Zofia is moving to health");
            zofia.setState(new MovingToHealth());
        } else if (zofia.isAtWealthResource()) {
            System.out.println("Zofia is moving to wealth");
            zofia.setState(new MovingToWealth());
        } else if (zofia.isAtPowerResource()) {
            System.out.println("Zofia is moving to power");
            zofia.setState(new MovingToPower());
        } else {
            System.out.println("Zofia cannot move due to lack of resources");
            zofia.setState(new MovingToHealth());
        }
    }
}
