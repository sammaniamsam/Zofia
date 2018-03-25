package personality_functions;

import zofia.Zofia;

/**
 * Created by Sam Man on 3/24/2018.
 */
public class Consumption1 implements PersonalityFunction {

    @Override
    public double calculateHealth(Zofia zofia) {
        // Having power decreases the amount of health consumed
        if(zofia.getMyPower() > 0) {
            return zofia.calculateDistance(zofia.getMyLocation(), zofia.getHealthLocation()) * 0.75;
        // Without power the full amount of health is consumed
        } else {
            return zofia.calculateDistance(zofia.getMyLocation(), zofia.getHealthLocation());
        }
    }

    @Override
    public double calculateWealth(Zofia zofia) {
        // Having power decreases the amount of wealth consumed
        if(zofia.getMyPower() > 0) {
            return zofia.calculateDistance(zofia.getMyLocation(), zofia.getWealthLocation()) * 0.9;
        // Without power the full amount of wealth is consumed
        } else if(zofia.getMyHealth() > 0) {
            return zofia.calculateDistance(zofia.getMyLocation(), zofia.getWealthLocation());
        // Without health, twice the amount of wealth is consumed
        } else {
            return zofia.calculateDistance(zofia.getMyLocation(), zofia.getWealthLocation()) * 1.5;
        }
    }

    @Override
    public double calculatePower(Zofia zofia) {
        // Power decreases at a constant rate that is not impacted by health or wealth
        return zofia.calculateDistance(zofia.getMyLocation(), zofia.getPowerLocation()) * 0.7;
    }
}
