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
    // na ten moment najprawdopodobniej zaimplementowalbym metode ktora posiadalaby tablice  dwuwymiarowa w jakim miejscu
    // znajduje sie jakis zwierzak. przy tworzeniu kazdego zwierzaka i poruszaniu sie nim, dane w tablicy bylyby
    // aktualizowane oraz mozliwosc przejscia na dane pola bylaby tylko wtedy gdy jest ono puste
}


