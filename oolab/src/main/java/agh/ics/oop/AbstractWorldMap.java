package agh.ics.oop;
import java.util.HashMap;

public abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver  {

    protected HashMap<Vector2d, Animal> animalsHashMap = new HashMap<>();
    protected MapBoundary mapBoundary = new MapBoundary();



    @Override
    public boolean place(Animal animal) throws IllegalArgumentException {
        if(canMoveTo(animal.getPosition())) {
            animalsHashMap.put(animal.getPosition(),animal);
            animal.addObserver(this);
            mapBoundary.addMapBoundary(animal.getPosition());
            return true;
        }
        else {
       throw new IllegalArgumentException("cannot place an Animal on " + animal.getPosition());}
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

    public abstract Vector2d getLeftLowerCorner();
    public abstract Vector2d getRightHigherCorner();

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal = animalsHashMap.get(oldPosition);
        animalsHashMap.remove(oldPosition);
        animalsHashMap.put(newPosition, animal);
        this.mapBoundary.positionChanged(oldPosition, newPosition);
    }


}
