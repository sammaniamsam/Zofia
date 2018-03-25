package personality_functions;

import zofia.Zofia;

/**
 * Created by Sam Man on 3/25/2018.
 */
public interface Selector {
    /**
     * Selects an action for Zofia to take
     * @param zofia
     */
    void select(Zofia zofia);
}
