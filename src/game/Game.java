package game;

import location.Position;
import personality_functions.Consumption2;
import personality_functions.Utility2;
import zofia.Zofia;

import java.util.Random;

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
        System.out.println("****************************");
        System.out.println("runZofia1");
        System.out.println("****************************");
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
         * RESULT: Zofia moved towards the wealth, because the linear utility function for wealth influenced her
         * to do so over the sigmoid function for health, even though the health resource was closer to than the wealth
         * resource.
         */
        health = new Position(35, 20);
        wealth = new Position(38, 20);
        power = new Position(0, 300);
        flag = new Position(110, 120);
        this.zofia = new Zofia(new Position(0,0), 50, 39, 100, health, wealth, power, flag);
        this.zofia.act();
        /**
         * RESULT: Zofia moved towards the power, because the exponential decay utility function for power influenced her
         * to do so over the other resource utility functions, the power resource must be located very close to Zofia for
         * her to go to it. It is highly unlikely that she will choose this resource.
         */
        //Iteration 4
        health = new Position(19, 29);
        wealth = new Position(26, 21);
        power = new Position(3, 4);
        flag = new Position(110, 120);
        this.zofia = new Zofia(new Position(0,0), 75, 75, 5, health, wealth, power, flag);
        this.zofia.act();
        /**
         * RESULT: Zofia was not able to move, because she was too far a distance from any resource.
         */
        //Iteration 5
        health = new Position(101, 330);
        wealth = new Position(215, 30);
        power = new Position(101, 125);
        flag = new Position(110, 120);
        this.zofia = new Zofia(new Position(0,0), 100, 100, 100, health, wealth, power, flag);
        this.zofia.act();
    }

    /**
     * Zofia personality 2.
     * Zofia using Utility1 class, Consumption1 class, and Action selector class.
     */
    private void runZofia2() {
        System.out.println("****************************");
        System.out.println("runZofia2");
        System.out.println("****************************");

        Random random = new Random();

        /**
         * RESULT: Will be random outcome as to what Zofia will do.
         */
        // Iterations 1 - 5
        for(int i=0; i < 5; i++){
            int x = random.nextInt(50) + 1, y = random.nextInt(50) + 1;
            Position health = new Position(x, y);
            x = random.nextInt(50) + 1;
            y = random.nextInt(50) + 1;
            Position wealth = new Position(x, y);
            x = random.nextInt(50) + 1;
            y = random.nextInt(50) + 1;
            Position power = new Position(x, y);
            x = random.nextInt(50) + 1;
            y = random.nextInt(50) + 1;
            Position flag = new Position(x, y);
            this.zofia = new Zofia(new Position(0, 0), random.nextInt(100) + 1, random.nextInt(100) + 1, random.nextInt(100) + 1, health, wealth, power, flag);
            this.zofia.setConsumptionStrategy(new Consumption2());
            this.zofia.setUtilityStrategy(new Utility2());
            this.zofia.act();
        }
    }

    ///////////////////////////////////////
    /* Distribution Action Selector */
    ///////////////////////////////////////

    private void runZofia3() {

    }

}
