package agh.ics.oop;
import java.util.Arrays;

public class World {

    public static void run(Direction[] directions) {

        System.out.println("Zwierzak wystartował");

        for(Direction direction : directions){
            String text = switch(direction) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case RIGHT -> "Zwierzak idzie w lewo";
                case LEFT -> "Zwierak idzie w prawo";
            };
            System.out.println(text);

        }

    }

    public static void string_to_enum(String[] args, Direction[] dirrectionsArray){

        int p = 0;
        int q = dirrectionsArray.length;

        for(int i = 0; i < dirrectionsArray.length; i++) {
            switch(args[i]) {
                case "f":
                    dirrectionsArray[p] = Direction.FORWARD;
                    p++;
                    break;
                case "b":
                    dirrectionsArray[p] = Direction.BACKWARD;
                    p++;
                    break;
                case "r":
                    dirrectionsArray[p] = Direction.RIGHT;
                    p++;
                    break;
                case "l":
                    dirrectionsArray[p] = Direction.LEFT;
                    p++;
                    break;
                default:
                    q--;
            }
        }

    }


    public static void main(String[] args) {

        int p = 0;
        System.out.println("System wystartowal");

        Direction[] dirrectionsArray = new Direction[args.length];
        string_to_enum(args,dirrectionsArray);

        for(Direction direction : dirrectionsArray){
            if (direction != null) {p++;}
        }

        Direction[] dirrectionsArrayCopy = Arrays.copyOf(dirrectionsArray,p);
        run(dirrectionsArrayCopy);


        System.out.println("system zakończył działanie");
    }

    }

