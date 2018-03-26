package personality_functions;

import location.Position;
import zofia.Zofia;

/**
 * Created by Sam Man on 3/24/2018.
 */
public class Consumption2 extends Consumption {

    @Override
    public double calculateHealth(Zofia zofia, Position target) {
        return zofia.calculateDistance(zofia.getMyLocation(), target);
    }

    @Override
    public double calculateWealth(Zofia zofia, Position target) {
        return zofia.calculateDistance(zofia.getMyLocation(), target);
    }

    @Override
    public double calculatePower(Zofia zofia, Position target) {
        // Power decreases at a constant rate that is not impacted by health or wealth
        return zofia.calculateDistance(zofia.getMyLocation(), target);
    }

}
