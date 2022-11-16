package agh.ics.oop;
import java.util.Arrays;

public class OptionsParser {

    public MoveDirection[] parse(String[] args){

        int p = 0;
        int n = args.length;
        MoveDirection[] Directions = new MoveDirection[n];

        for (String direction : args){
            switch (direction){
                case "f", "forward" -> {
                    Directions[p] = MoveDirection.FORWARD;
                    p++;
                }
                case "b" , "backward " -> {
                    Directions[p] = MoveDirection.BACKWARD;
                    p++;
                }
                case "r", "right" -> {
                    Directions[p] = MoveDirection.RIGHT;
                    p++;
                }
                case "l", "left" -> {
                    Directions[p] = MoveDirection.LEFT;
                    p++;
                }
                default -> {}
            }
        }

        MoveDirection[] DirectionsOk = Arrays.copyOf(Directions,p);
        return DirectionsOk;
    }
}
