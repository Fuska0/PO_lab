package agh.ics.oop;
import java.util.Arrays;

public class OptionsParser {

    public MoveDirection[] parse(String[] args){

        int counter = 0;
        int n = args.length;
        MoveDirection[] Directions = new MoveDirection[n];

        for (String direction : args){
            switch (direction){
                case "f", "forward" -> {
                    Directions[counter] = MoveDirection.FORWARD;
                    counter++;
                }
                case "b" , "backward " -> {
                    Directions[counter] = MoveDirection.BACKWARD;
                    counter++;
                }
                case "r", "right" -> {
                    Directions[counter] = MoveDirection.RIGHT;
                    counter++;
                }
                case "l", "left" -> {
                    Directions[counter] = MoveDirection.LEFT;
                    counter++;
                }
                default -> {}
            }
        }

        MoveDirection[] DirectionsOk = Arrays.copyOf(Directions,counter);
        return DirectionsOk;

    }
}
