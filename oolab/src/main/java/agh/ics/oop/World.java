package agh.ics.oop;
import java.util.Arrays;


public class World {

    public static void run(Direction[] directions) {

        System.out.println("Zwierzak wystartował");

        for (Direction direction : directions) {
            String text = switch (direction) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case RIGHT -> "Zwierzak idzie w lewo";
                case LEFT -> "Zwierak idzie w prawo";
            };
            System.out.println(text);

        }


    }

    public static void StringToEnum(String[] args, Direction[] dirrectionsArray) {

        int p = 0;
        int q = dirrectionsArray.length;

        for (int i = 0; i < dirrectionsArray.length; i++) {
            switch (args[i]) {
                case "f" -> {
                    dirrectionsArray[p] = Direction.FORWARD;
                    p++;
                }
                case "b" -> {
                    dirrectionsArray[p] = Direction.BACKWARD;
                    p++;
                }
                case "r" -> {
                    dirrectionsArray[p] = Direction.RIGHT;
                    p++;
                }
                case "l" -> {
                    dirrectionsArray[p] = Direction.LEFT;
                    p++;
                }
                default -> q--;
            }
        }

    }


    public static void main(String[] args) {

        int p = 0;
        System.out.println("System wystartowal");

        Direction[] dirrectionsArray = new Direction[args.length];
        StringToEnum(args,dirrectionsArray);

        for(Direction direction : dirrectionsArray){
            if (direction != null) {p++;}
        }

        Direction[] dirrectionsArrayCopy = Arrays.copyOf(dirrectionsArray,p);
        run(dirrectionsArrayCopy);

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.Add(position2));

        MapDirection direction1 = MapDirection.SOUTH;
        System.out.println(direction1.ToString(direction1));
        System.out.println(direction1.next(direction1));
        System.out.println(direction1.previous(direction1));
        System.out.println(direction1.toUnitVector(direction1));


        System.out.println("system zakończył działanie :) ");
    }
    // moze zadziala
}


