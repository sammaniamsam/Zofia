package game;

import location.Position;
import zofia.Zofia;

/**
 * Created by Sam Man on 3/24/2018.
 */
public class Game {

    private Position flag;
    private Position health;
    private Position wealth;
    private Position power;
    private Zofia zofia;

    public Game() {
        /* Non Distribution Action Selector */
        runZofia1();
        runZofia2();
        /* Distribution Action Selector */
    }

    ///////////////////////////////////////
    /* Non Distribution Action Selector */
    ///////////////////////////////////////
    /**
     * Zofia personality 1.
     * Zofia using Utility1 class, Consumption1 class, and Action selector class.
     */
    private void runZofia1() {
        //Iteration 1
        /**
         * RESULT: Zofia moved towards the flag, because she had enough resources to do so on the
         * first try.
         */
        Position health = new Position(41, 30);
        Position wealth = new Position(40, 30);
        Position power = new Position(0, 300);
        Position flag = new Position(20, 10);
        this.zofia = new Zofia(new Position(0,0), 25, 50, 100, health, wealth, power, flag);
        this.zofia.act();
        //Iteration 2
        /**
         * RESULT: Zofia moved towards the health, because the sigmoid utility function for health influenced her
         * to do so over the linear function for wealth, given Zofia's resource levels and the resource positions
         */
        health = new Position(22, 22);
        wealth = new Position(20, 20);
        power = new Position(0, 300);
        flag = new Position(110, 120);
        this.zofia = new Zofia(new Position(0,0), 25, 25, 100, health, wealth, power, flag);
        this.zofia.act();
        //Iteration 3
        /**
         * RESULT: Zofia moved towards the health, because the sigmoid utility function for health influenced her
         * to do so over the linear function for wealth, given Zofia's resource levels and the resource positions
         */
        health = new Position(41, 30);
        wealth = new Position(40, 30);
        power = new Position(0, 300);
        flag = new Position(110, 120);
        this.zofia = new Zofia(new Position(0,0), 25, 50, 100, health, wealth, power, flag);
        this.zofia.act();
        //Iteration 4
        health = new Position(41, 30);
        wealth = new Position(40, 30);
        power = new Position(0, 300);
        flag = new Position(110, 120);
        this.zofia = new Zofia(new Position(0,0), 25, 50, 100, health, wealth, power, flag);
        this.zofia.act();
        //Iteration 5
        health = new Position(41, 30);
        wealth = new Position(40, 30);
        power = new Position(0, 300);
        flag = new Position(110, 120);
        this.zofia = new Zofia(new Position(0,0), 25, 50, 100, health, wealth, power, flag);
        this.zofia.act();
    }

    /**
     * Zofia personality 1.
     * Zofia using Utility1 class, Consumption1 class, and Action selector class.
     */
    private void runZofia2() {

    }

    ///////////////////////////////////////
    /* Distribution Action Selector */
    ///////////////////////////////////////
}
