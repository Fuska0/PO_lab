import agh.ics.oop.MapDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {

    @Test

    void MapDirectionNext(){
        MapDirection direction1 = MapDirection.SOUTH;
        MapDirection direction2 = MapDirection.NORTH;
        MapDirection direction3 = MapDirection.EAST;
        MapDirection direction4 = MapDirection.WEST;

        assertEquals(MapDirection.WEST, direction1.next(direction1));
        assertEquals(MapDirection.EAST, direction2.next(direction2));
        assertEquals(MapDirection.SOUTH, direction3.next(direction3));
        assertEquals(MapDirection.NORTH, direction4.next(direction4));

    }

    @Test

    void MapDirectionPrevious(){
        MapDirection direction1 = MapDirection.SOUTH;
        MapDirection direction2 = MapDirection.NORTH;
        MapDirection direction3 = MapDirection.EAST;
        MapDirection direction4 = MapDirection.WEST;

        assertEquals(MapDirection.EAST, direction1.previous(direction1));
        assertEquals(MapDirection.WEST, direction2.previous(direction2));
        assertEquals(MapDirection.NORTH, direction3.previous(direction3));
        assertEquals(MapDirection.SOUTH, direction4.previous(direction4));

    }

// sprawdzam czy push dziala 2
}
