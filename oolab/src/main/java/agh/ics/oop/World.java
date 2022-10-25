package agh.ics.oop;

public class World {

    public static void main(String[] args) {

        Animal rakLucyna = new Animal();
        OptionsParser optionsParser = new OptionsParser();

        System.out.println(rakLucyna.toString());

        MoveDirection[] Directions = optionsParser.parse(args);

        for(MoveDirection directions: Directions){
            rakLucyna.move(directions);
        }
         System.out.println(rakLucyna.toString());


    }
    // moze zadziala proba kolejna
}


