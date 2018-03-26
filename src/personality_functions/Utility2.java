package personality_functions;

import zofia.Zofia;

/**
 * Created by Sam Man on 3/24/2018.
 */
public class Utility2 extends Utility {

    /**
     * Exponential Decay function based on maximum 'X' value of 100
     * @param zofia
     * @return double that represents the utility of health
     */
    @Override
    public double calculateHealth(Zofia zofia) {
        return Math.pow(0.96, (zofia.getMyPower() - 112.8));
    }

    /**
     * Sigmoid Curve function based on maximum 'X' value of 100
     * @param zofia
     * @return double that represents the utility of wealth
     */
    @Override
    public double calculateWealth(Zofia zofia) {
        return 100.0 / (1.0 + (Math.pow(Math.E, (0.1 * (zofia.getMyHealth() - 50.0)))));
    }

    /**
     * Linear function based on maximum 'X' value of 100
     * @param zofia
     * @return double that represents the utility of wealth
     */
    @Override
    public double calculatePower(Zofia zofia) {
        return 100.0 - zofia.getMyWealth();
    }
}
