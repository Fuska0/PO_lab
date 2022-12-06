package agh.ics.oop;
import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{

    public final MoveDirection[] moveDirections;
    public IWorldMap map;
    public final Vector2d[] positions;

    public SimulationEngine(MoveDirection[] moveDirections, IWorldMap map, Vector2d[] positions){
        this.moveDirections = moveDirections;
        this.map = map;
        this.positions = positions;
        for (Vector2d position : positions) {
            if(map.canMoveTo(position)){
                map.place(new Animal(map, position));
            }
            else {throw new IllegalArgumentException("cannot place an Animal on " + position);}
            }
        }


    public void run(){

        int AnimalsNumber = positions.length;

        for (int i=0;i<moveDirections.length;i++){
            Animal newAnimal = (Animal) map.objectAt(positions[i%AnimalsNumber]);
            newAnimal.move(moveDirections[i]);
            positions[i%AnimalsNumber] = newAnimal.getPosition();
        }

    }
}
