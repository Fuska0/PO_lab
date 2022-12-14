import agh.ics.oop.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {
    @Test
    public void allCorrectLinesTest(){

        String[] moves={"r","b","b","l","l","f","b", "l","b","b","left", "right"};

        MoveDirection f = MoveDirection.FORWARD;
        MoveDirection b = MoveDirection.BACKWARD;
        MoveDirection l = MoveDirection.LEFT;
        MoveDirection r = MoveDirection.RIGHT;
        MoveDirection[] correct={r,b,b,l,l,f,b,l,b,b,l,r};

        MoveDirection[] check=OptionsParser.parse(moves);
        assertArrayEquals(correct,check);
    }
}
