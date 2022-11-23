package agh.ics.oop;
import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private final int width;
    private final int height;
    public List<Animal> animalList;
    public MapVisualizer mapVisualizer;
    public static final Vector2d LOWER_BOUND = new Vector2d(0,0); //takie nasze wprowadzone stale, moga byc prywatne

    public RectangularMap(int height, int width) {
        this.width = height-1;
        this.height = width-1;
        this.animalList = new ArrayList<>();
        this.mapVisualizer = new MapVisualizer(this);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.Follows(LOWER_BOUND) && position.Precedes(new Vector2d(width, height))
                && !this.isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (this.canMoveTo(animal.getPosition())){
            animalList.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animalList) {
            if (animal.isAt(position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : animalList) {
            if (animal.isAt(position)) {
                return animal;
            }
        }
        return null;
    }

    public String toString() {
        return mapVisualizer.draw(LOWER_BOUND, new Vector2d(width, height));
    }
}
