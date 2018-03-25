package game;

import location.Position;
import zofia.Zofia;

import java.util.InputMismatchException;
import java.util.Scanner;

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
    }

    private void createZofia() {
        // Based on a 10 X 10 Board
        Position health = new Position(1, 5);
        Position wealth = new Position(4, 3);
        Position power = new Position(0, 3);
        this.zofia = new Zofia(new Position(0,0), 25, 50, 100, health, wealth, power);
    }

}
