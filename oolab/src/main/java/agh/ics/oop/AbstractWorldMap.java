package agh.ics.oop;
import java.util.HashMap;

abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver  {

    protected HashMap<Vector2d, Animal> animalsHashMap = new HashMap<>();


    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition())) {
            animalsHashMap.put(animal.getPosition(),animal);
            animal.addObserver(this);
            return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animalsHashMap.get(position);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public String toString() {
        MapVisualizer map = new MapVisualizer(this);
        return map.draw(getLeftLowerCorner(), getRightHigherCorner());
    }

    abstract Vector2d getLeftLowerCorner();
    abstract Vector2d getRightHigherCorner();

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = animalsHashMap.get(oldPosition);
        animalsHashMap.remove(oldPosition);
        animalsHashMap.put(newPosition, animal);
    }


}
