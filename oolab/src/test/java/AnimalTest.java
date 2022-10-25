import agh.ics.oop.Animal;
import agh.ics.oop.MapDirection;
import agh.ics.oop.MoveDirection;
import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    String[] args1 = {"f","f","f","b","l","f","f","l","f","f","f","r"}; // orientacja + pozycja + wyjscie poza mape
    String[] args2 = {"l","l","l","b","b","b","r","r","f","b","r"}; // orientacja + pozycja + wyjscie poza mape
    String[] args3 = {"f","f","f","f","f","f","f","f","r","f","f","f","f","f","f","f","f"}; // mocne wyjscie poza mape
    String[] args4 ={"f","a","b","c","l","o","r"};

    OptionsParser optionsParser = new OptionsParser();

    MoveDirection[] Directions1 = optionsParser.parse(args1);
    MoveDirection[] Directions2 = optionsParser.parse(args2);
    MoveDirection[] Directions3 = optionsParser.parse(args3);
    MoveDirection[] Directions4 = optionsParser.parse(args4);
    

    @Test
    void orientationAndPosition (){

        Animal rakMaciej = new Animal();
        Animal rakOla = new Animal();

        for(MoveDirection directions: Directions1){
            rakMaciej.move(directions);
        }

        for(MoveDirection directions: Directions2){
            rakOla.move(directions);
        }

        assertEquals("((0,0), WEST)",rakMaciej.toString());
        assertEquals("((1,2), NORTH)",rakOla.toString());


    }

    void limits(){

        Animal rakJulia = new Animal();

        for(MoveDirection directions: Directions3){
            rakJulia.move(directions);
        }

        assertEquals("((4,4), EAST)",rakJulia.toString());
    }

    @Test
    void directions(){

        assertEquals(Directions4[0], MoveDirection.FORWARD);
        assertEquals(Directions4[1], MoveDirection.BACKWARD);
        assertEquals(Directions4[2], MoveDirection.LEFT);
        assertEquals(Directions4[3], MoveDirection.RIGHT);

    }

}
