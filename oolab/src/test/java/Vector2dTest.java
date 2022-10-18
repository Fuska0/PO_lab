import agh.ics.oop.Vector2d;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class Vector2dTest {

    @Test
    void VectorEquals(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1,2);
        int v3 = 2;
        Vector2d v4 = new Vector2d(2,1);

        assertEquals(v1, v2);
        assertNotEquals(v1, v3);
        assertNotEquals(v1, v4);

    }

    @Test
    void VectorToString(){
        Vector2d v1 = new Vector2d(40,1);
        assertEquals("(40,1)",v1.toString());

    }

    @Test
    void VectorsPrecedes(){
        Vector2d v1 = new Vector2d(10,13);
        Vector2d v2 = new Vector2d(2,11);
        Vector2d v3 = new Vector2d(11,11);

        assertTrue(v2.Precedes(v1));
        assertFalse(v3.Precedes(v1));

    }

    @Test
    void CextorsFollows(){
        Vector2d v1 = new Vector2d(10,13);
        Vector2d v2 = new Vector2d(2,11);
        Vector2d v3 = new Vector2d(11,11);

        assertTrue(v1.Follows(v2));
        assertFalse(v3.Follows(v1));

    }

    @Test
    void vectorsUpperRight(){
        Vector2d v1 = new Vector2d(10,1);
        Vector2d v2 = new Vector2d(2,11);
        Vector2d v3 = v1.UpperRight(v2);

        assertEquals(10,v3.x);
        assertEquals(11,v3.y);
    }

    @Test
    void vectorsLowerLeft(){
        Vector2d v1 = new Vector2d(10,1);
        Vector2d v2 = new Vector2d(2,11);
        Vector2d v3 = v1.LowerLeft(v2);

        assertEquals(2,v3.x);
        assertEquals(1,v3.y);
    }

    @Test
    void vectorsCanBeAdded(){
        Vector2d v1 = new Vector2d(5,2);
        Vector2d v2 = new Vector2d(3,-1);
        Vector2d v3 = v1.Add(v2);

        assertEquals(8,v3.x);
        assertEquals(1,v3.y);
    }

    @Test
    void VectorSubtract(){
        Vector2d v1 = new Vector2d(10,1);
        Vector2d v2 = new Vector2d(2,11);
        Vector2d v3 = v1.Subtract(v2);

        assertEquals(8,v3.x);
        assertEquals(-10,v3.y);
    }

    @Test
    void VectorOpposite(){
        Vector2d v1 = new Vector2d(10,1);
        Vector2d v2 = v1.Opposite();

        assertEquals(-10,v2.x);
        assertEquals(-1,v2.y);
    }

    //sprawdzam czy push dziala

}
