package personality_functions;

import zofia.Zofia;

/**
 * Created by Sam Man on 3/25/2018.
 */
public abstract class Selector {
    /**
     * Selects an action for Zofia to take
     * @param zofia
     */
    public abstract void select(Zofia zofia);
}
