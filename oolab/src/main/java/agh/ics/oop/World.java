package agh.ics.oop;

//import java.awt.*;
import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World {

    public static void main(String[] args) {
//        try {
//        MoveDirection[] directions = new OptionsParser().parse(args);
//        AbstractWorldMap map = new GrassField(10);
//        Vector2d[] positions = {  new Vector2d(1,1), new Vector2d(5,6), new Vector2d(5,6) };
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        engine.run();
//        System.out.println(map.toString());}
//        catch(IllegalArgumentException e) {System.out.println("Error " + e);}
        Application.launch(App.class, args);

    }
}