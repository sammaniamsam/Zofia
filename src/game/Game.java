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
        createZofia();
        this.zofia = new Zofia(this.zofia, 19, 50, 100);
        //System.out.println(this.zofia.calculateHealthUtility());
        //System.out.println(this.zofia.calculateWealthUtility());
        //System.out.println(this.zofia.calculatePowerUtility());
        System.out.println(this.zofia.calculateHealthConsumption());
        System.out.println(this.zofia.calculateWealthConsumption());
        System.out.println(this.zofia.calculatePowerConsumption());
    }

    private void createZofia() {
        // Based on a 10 X 10 Board
        Position health = new Position(100, 50);
        Position wealth = new Position(40, 30);
        Position power = new Position(0, 300);
        Position flag = new Position(9, 10);
        this.zofia = new Zofia(new Position(0,0), 25, 50, 100, health, wealth, power, flag);
    }

}
