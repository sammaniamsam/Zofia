package personality_functions;

import location.Position;
import zofia.Zofia;

/**
 * Created by Sam Man on 3/24/2018.
 */
public class Consumption1 extends Consumption {

    @Override
    public double calculateHealth(Zofia zofia, Position target) {
        // Having power decreases the amount of health consumed
        if(zofia.getMyPower() > 0) {
            return zofia.calculateDistance(zofia.getMyLocation(), target) * 0.75;
        // Without power the full amount of health is consumed
        } else {
            return zofia.calculateDistance(zofia.getMyLocation(), target);
        }
    }

    @Override
    public double calculateWealth(Zofia zofia, Position target) {
        // Having power decreases the amount of wealth consumed
        if(zofia.getMyPower() > 0) {
            return zofia.calculateDistance(zofia.getMyLocation(), target) * 0.9;
        // Without power the full amount of wealth is consumed
        } else if(zofia.getMyHealth() > 0) {
            return zofia.calculateDistance(zofia.getMyLocation(), target);
        // Without health, twice the amount of wealth is consumed
        } else {
            return zofia.calculateDistance(zofia.getMyLocation(), target) * 1.5;
        }
    }

    @Override
    public double calculatePower(Zofia zofia, Position target) {
        // Power decreases at a constant rate that is not impacted by health or wealth
        return zofia.calculateDistance(zofia.getMyLocation(), target) * 0.7;
    }
}
