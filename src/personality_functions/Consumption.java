package personality_functions;

import location.Position;
import zofia.Zofia;

/**
 * Created by Sam Man on 3/25/2018.
 */
public abstract class Consumption {

    public abstract double calculateHealth(Zofia zofia, Position target);
    public abstract double calculateWealth(Zofia zofia, Position target);
    public abstract double calculatePower(Zofia zofia, Position target);

}
