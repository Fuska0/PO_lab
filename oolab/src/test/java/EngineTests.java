import agh.ics.oop.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EngineTests {

    @Test
    void mapTest(){

        String[] args = new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();


        String[] args2 = new String[]{"f", "b", "r", "k", "l", "f", "f", "i", "r", "r", "f", "f",
                "h", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions2 = new OptionsParser().parse(args2);
        IWorldMap map2 = new RectangularMap(10, 8);
        Vector2d[] positions2 = { new Vector2d(2,2), new Vector2d(0,0), new Vector2d(3,4) };
        IEngine engine2 = new SimulationEngine(directions2, map2, positions2);
        engine2.run();


        Animal rakOla = (Animal) map.objectAt(new Vector2d(2,0));
        Animal rakKuba = (Animal) map.objectAt(new Vector2d(3,4));
        Animal rakWiktor = (Animal) map2.objectAt(new Vector2d(2,1));
        Animal rakLukasz = (Animal) map2.objectAt(new Vector2d(2,6));
        Animal rakAndrzej = (Animal) map2.objectAt(new Vector2d(7,4));

        assertEquals(rakOla.getOrientatnio(),MapDirection.SOUTH);
        assertEquals(rakKuba.getOrientatnio(),MapDirection.NORTH);
        assertEquals(rakWiktor.getOrientatnio(),MapDirection.EAST);
        assertEquals(rakLukasz.getOrientatnio(),MapDirection.NORTH);
        assertEquals(rakAndrzej.getOrientatnio(),MapDirection.EAST);


        assertTrue(map.isOccupied(new Vector2d(2,0)));
        assertTrue(map.isOccupied(new Vector2d(3,4)));
        assertTrue(map2.isOccupied(new Vector2d(2,1)));
        assertTrue(map2.isOccupied(new Vector2d(2,6)));
        assertTrue(map2.isOccupied(new Vector2d(7,4)));

    }

}
