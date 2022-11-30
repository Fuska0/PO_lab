import agh.ics.oop.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTests {

    @Test
    void objectAtTest() {

        //given
        GrassField map = new GrassField(0);

        Vector2d Position1 = new Vector2d(0, 0);
        Vector2d Position2 = new Vector2d(1, 2);
        Vector2d Position3 = new Vector2d(4, 6);

        Animal animal1 = new Animal(map, Position1);
        Animal animal2 = new Animal(map, Position2);
        map.addGrass(Position2);
        map.place(animal1);

        //objectAt
        assertNull(map.objectAt(Position3));
        assertTrue(map.objectAt(Position2)  instanceof Grass);
        assertTrue(map.objectAt(Position1) instanceof Animal);

        map.place(animal2);
        assertTrue(map.objectAt(Position2) instanceof Animal);

        //canMoveTo
        assertFalse(map.canMoveTo(Position2));
        assertTrue(map.canMoveTo(Position3));

        //isOccupied
        assertTrue(map.isOccupied(Position1));
        assertFalse(map.isOccupied(Position3));

    }


}