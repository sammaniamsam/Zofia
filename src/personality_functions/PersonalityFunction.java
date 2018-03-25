package personality_functions;

import zofia.Zofia;

/**
 * Created by Sam Man on 3/24/2018.
 */
public interface PersonalityFunction {
    double calculateHealth(Zofia zofia);
    double calculateWealth(Zofia zofia);
    double calculatePower(Zofia zofia);
}
