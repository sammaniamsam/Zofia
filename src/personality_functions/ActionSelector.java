package personality_functions;

import zofia.Zofia;

/**
 * Created by Sam Man on 3/24/2018.
 */
public class ActionSelector extends Selector {

    @Override
    public void select(Zofia zofia) {
        if(hasEnoughHealth(zofia) || hasEnoughWealth(zofia) || hasEnoughPower(zofia)) {
            zofia.moveTo(zofia.getFlagLocation());
        } else {
            double healthScore = zofia.getMyHealth() > 0 ? zofia.calculateHealthUtility() : 0.0;
            double wealthScore = zofia.getMyWealth() > 0 ? zofia.calculateWealthUtility() : 0.0;
            double powerScore = zofia.getMyPower() > 0 ? zofia.calculatePowerUtility() : 0.0;
            //System.out.println(powerScore);

            double healthConsumption = zofia.getMyHealth() - zofia.calculateHealthConsumption(zofia.getHealthLocation());
            double wealthConsumption = zofia.getMyWealth() - zofia.calculateWealthConsumption(zofia.getWealthLocation());
            double powerConsumption = zofia.getMyPower() - zofia.calculatePowerConsumption(zofia.getPowerLocation());
            //System.out.println(powerConsumption);

            if(healthConsumption > 0 || wealthConsumption > 0 || powerConsumption > 0) {
                if(healthConsumption > 0) {
                    zofia.moveTo(zofia.getHealthLocation());
                } if(wealthConsumption > 0) {
                    if(isHighScore(wealthScore, healthScore)) { zofia.moveTo(zofia.getWealthLocation()); }
                } if (powerConsumption > 0) {
                    if(isHighScore(powerScore, wealthScore, healthScore)) { zofia.moveTo(zofia.getPowerLocation()); }
                }
            }
        }
    }

    private boolean hasEnoughHealth(Zofia zofia) {
        return zofia.getMyHealth() - zofia.calculateHealthConsumption(zofia.getFlagLocation()) > 0;
    }

    private boolean hasEnoughWealth(Zofia zofia) {
        return zofia.getMyWealth() - zofia.calculateWealthConsumption(zofia.getFlagLocation()) > 0;
    }

    private boolean hasEnoughPower(Zofia zofia) {
        return zofia.getMyPower() - zofia.calculatePowerConsumption(zofia.getFlagLocation()) > 0;
    }

    private boolean isHighScore(double a, double b, double c) {
        return a > b && a > c;
    }

    private boolean isHighScore(double a, double b) {
        return a > b;
    }

}
