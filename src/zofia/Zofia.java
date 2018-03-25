package zofia;

import location.Position;
import personality_functions.PersonalityFunction;
import states.State;
import states.Stationary;

/**
 * Created by Sam Man on 3/24/2018.
 */
public class Zofia {

    private State myState;
    private Position myLocation;
    private int myHealth;
    private int myWealth;
    private int myPower;
    private Position healthLocation;
    private Position wealthLocation;
    private Position powerLocation;
    private PersonalityFunction consumption;
    private PersonalityFunction utility;

    public Zofia(State myState, Position myLocation, int myHealth, int myWealth, int myPower,
        Position healthLocation, Position wealthLocation, Position powerLocation) {
        this.setState(new Stationary());
        this.myLocation = myLocation;
        this.myHealth = myHealth;
        this.myWealth = myWealth;
        this.myPower = myPower;
        this.healthLocation = healthLocation;
        this.wealthLocation = wealthLocation;
        this.powerLocation = powerLocation;
    }

    /**
     * Setter method for the state.
     * Should only be called by classes implementing the State interface.
     * @param newState the new state of Zofia.
     */
    public void setState(State newState) {
        this.myState = newState;
    }

    /**
     * Set strategy
     * @param consumption PersonalityFunction strategy that is set for the Zofina's
     * calculateConsumption method.
     */
    public void setConsumptionStrategy(PersonalityFunction consumption) {
        this.consumption = consumption;
    }

    /**
     * Set strategy
     * @param utility PersonalityFunction strategy that is set for the Zofina's
     * calculateUtility method.
     */
    public void setUtilityStrategy(PersonalityFunction utility) {
        this.utility = utility;
    }

    /**
     * Zofina will take certain actions based on the state she's in.
     */
    public void act() {
        this.myState.act(this);
    }

    public double calculateConsumption() {
        return this.consumption.calculate(this);
    }

    public double calculateUtility() {
        return this.utility.calculate(this);
    }

    public State getMyState() {
        return myState;
    }

    public Position getMyLocation() {
        return myLocation;
    }

    public int getMyHealth() {
        return myHealth;
    }

    public int getMyWealth() {
        return myWealth;
    }

    public int getMyPower() {
        return myPower;
    }

    public Position getHealthLocation() {
        return healthLocation;
    }

    public Position getWealthLocation() {
        return wealthLocation;
    }

    public Position getPowerLocation() {
        return powerLocation;
    }


}
