package agh.ics.oop;

import java.awt.*;

public class World {

//    public static final Vector2d LOWER_BOUND = new Vector2d(0,0); //takie nasze wprowadzone stale, moga byc prywatne
//    public static final Vector2d UPPER_BOUND = new Vector2d(4,4); //takie nasze wprowadzone stale

    public static void main(String[] args) {

        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 8);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(0,0), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        System.out.println(map.toString());

    }
}


