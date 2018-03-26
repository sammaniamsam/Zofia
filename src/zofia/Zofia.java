package zofia;

import location.Position;
import personality_functions.*;
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
    private Position flagLocation;
    private Consumption consumption;
    private Utility utility;
    private Selector selector;

    /**
     *
     * @param myLocation
     * @param myHealth
     * @param myWealth
     * @param myPower
     * @param healthLocation
     * @param wealthLocation
     * @param powerLocation
     */
    public Zofia(Position myLocation, int myHealth, int myWealth, int myPower,
        Position healthLocation, Position wealthLocation, Position powerLocation, Position flagLocation) {
        this.setState(new Stationary());
        this.setUtilityStrategy(new Utility1());
        this.setConsumptionStrategy(new Consumption1());
        this.setActionSelector(new ActionSelector());
        this.myLocation = myLocation;
        this.myHealth = myHealth;
        this.myWealth = myWealth;
        this.myPower = myPower;
        this.healthLocation = healthLocation;
        this.wealthLocation = wealthLocation;
        this.powerLocation = powerLocation;
        this.flagLocation = flagLocation;
    }

    /**
     *
     * @param zofia
     * @param myHealth
     * @param myWealth
     * @param myPower
     */
    public Zofia(Zofia zofia, int myHealth, int myWealth, int myPower) {
        this.setState(zofia.getMyState());
        this.setUtilityStrategy(zofia.getUtility());
        this.setConsumptionStrategy(zofia.getConsumption());
        this.setActionSelector(zofia.getSelector());
        this.myLocation = zofia.getMyLocation();
        this.myHealth = myHealth;
        this.myWealth = myWealth;
        this.myPower = myPower;
        this.healthLocation = zofia.getHealthLocation();
        this.wealthLocation = zofia.getWealthLocation();
        this.powerLocation = zofia.getPowerLocation();
        this.flagLocation = zofia.getFlagLocation();
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
     * @param consumption Utility strategy that is set for Zofia's
     * calculateConsumption method.
     */
    public void setConsumptionStrategy(Consumption consumption) {
        this.consumption = consumption;
    }

    /**
     * Set strategy
     * @param utility Utility strategy that is set for Zofia's
     * calculateUtility method.
     */
    public void setUtilityStrategy(Utility utility) {
        this.utility = utility;
    }

    /**
     * Set strategy
     * @param selector Selector strategy that is set for Zofia's select method.
     */
    public void setActionSelector(Selector selector) {
        this.selector = selector;
    }

    /**
     * Zofia will take certain actions based on the state she's in
     */
    public void act() {
        this.selector.select(this);
        this.myState.act(this);
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public Double calculateDistance(Position a, Position b) {
        return Math.sqrt(Math.pow((b.getX() - a.getX()), 2) + Math.pow((b.getY() - a.getY()), 2));
    }

    /**
     *
     * @param newLocation
     */
    public void moveTo(Position newLocation) {
        this.myLocation = newLocation;
    }

    public double calculateHealthConsumption(Position target) {
        return this.consumption.calculateHealth(this, target);
    }

    public double calculateWealthConsumption(Position target) {
        return this.consumption.calculateWealth(this, target);
    }

    public double calculatePowerConsumption(Position target) {
        return this.consumption.calculatePower(this, target);
    }

    public double calculateHealthUtility() {
        return this.utility.calculateHealth(this);
    }

    public double calculateWealthUtility() {
        return this.utility.calculateWealth(this);
    }

    public double calculatePowerUtility() {
        return this.utility.calculatePower(this);
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

    public Consumption getConsumption() { return consumption;}

    public Utility getUtility() { return utility; }

    public Selector getSelector() { return selector; }

    public Position getFlagLocation() { return flagLocation; }

    public boolean isAtFlag() {
        return this.myLocation.getX() == this.flagLocation.getX() &&
            this.myLocation.getY() == this.flagLocation.getY();
    }

    public boolean isAtHealthResource() {
        return this.myLocation.getX() == this.healthLocation.getX() &&
                this.myLocation.getY() == this.healthLocation.getY();
    }

    public boolean isAtWealthResource() {
        return this.myLocation.getX() == this.wealthLocation.getX() &&
                this.myLocation.getY() == this.wealthLocation.getY();
    }
    public boolean isAtPowerResource() {
        return this.myLocation.getX() == this.powerLocation.getX() &&
                this.myLocation.getY() == this.powerLocation.getY();
    }

    /**
     * Recharges the appropriate resource for Zofia
     */
    public void recharge() {
        if(this.isAtPowerResource()) {
            this.myPower = 100;
        } else if (this.isAtWealthResource()) {
            this.myWealth = 100;
        } else if (this.isAtHealthResource()) {
            this.myHealth = 100;
        }
    }
}
