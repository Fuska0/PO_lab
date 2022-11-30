import agh.ics.oop.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTests {

    @Test
    void rectangularMapTests() {
        RectangularMap map = new RectangularMap(10, 10);
        Vector2d position = new Vector2d(2, 1);
        Animal animal = new Animal(map, position);
        map.place(animal);

        //objectAt
        assertNull(map.objectAt(new Vector2d(1, 2)));
        assertTrue(map.objectAt(position) instanceof Animal);
        //canMoveTo
        assertFalse(map.canMoveTo(position));
        assertTrue(map.canMoveTo(new Vector2d(1, 2)));
        //isOccupied
        assertTrue(map.isOccupied(position));
        assertFalse(map.isOccupied(new Vector2d(1, 2)));
    }

}
