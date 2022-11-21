package agh.ics.oop;

import java.awt.*;

public class World {

    public static void main(String[] args) {

        MoveDirection[] directions = new OptionsParser().parse(args);
        AbstractWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(0,0), new Vector2d(3,4) , new Vector2d(2,5)  };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        System.out.println(map.toString());
    }
}


