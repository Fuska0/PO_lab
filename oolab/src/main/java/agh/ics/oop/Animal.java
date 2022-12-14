package agh.ics.oop;
import java.util.ArrayList;
import java.util.Objects;

public class Animal {

    private MapDirection orientation;
    private Vector2d position;
    public IWorldMap map;
    private ArrayList<IPositionChangeObserver> observers = new ArrayList<>();

    public Animal(IWorldMap map)
    {
        this.map = map;
        this.orientation = MapDirection.NORTH;
    }
    public Animal(IWorldMap map, Vector2d initialPosition)
    {
        this.map = map;
        this.position = initialPosition;
        this.orientation = MapDirection.NORTH;
    }

    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getOrientatnio(){
        return orientation;
    }


    public MapDirection getDirection() {
        return orientation;
    }

    @Override
    public String toString() {
        return switch (orientation){
            case EAST -> "E";
            case WEST -> "W";
            case NORTH -> "N";
            case SOUTH -> "S";
        };

    }


    public boolean isAt(Vector2d position2){
        return Objects.equals(position, position2); // lepiej uzyc Objects.equals zamiast equals!!!
    }

    public void move(MoveDirection direction){
        Vector2d newPosition = position;
        switch(direction){

            case RIGHT -> orientation = orientation.next(orientation);
            case LEFT -> orientation = orientation.previous(orientation);
            case FORWARD -> newPosition = position.Add(orientation.toUnitVector(orientation));
            case BACKWARD -> newPosition = position.Subtract(orientation.toUnitVector(orientation));

        }

        if(map.canMoveTo(newPosition)){
            positionChanged(position, newPosition);
            position = newPosition;
        }

    }

    public void removeObserver(IPositionChangeObserver observer) {
        observers.remove(observer);
    }
    public void addObserver(IPositionChangeObserver observer) {
        observers.add(observer);
    }
    private void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver observer : observers){
            observer.positionChanged(oldPosition, newPosition);
        }
    }

}

