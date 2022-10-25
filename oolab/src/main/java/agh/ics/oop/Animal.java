package agh.ics.oop;

public class Animal {

    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    public String toString(){ return "(" + position + ", " + orientation + ")";}

    public boolean isAt(Vector2d position2){ return position.equals(position2);}

    public void move(MoveDirection direction){
        switch(direction){

            case RIGHT -> orientation = orientation.next(orientation);
            case LEFT -> orientation = orientation.previous(orientation);
            case FORWARD -> position = position.Add(orientation.toUnitVector(orientation));
            case BACKWARD -> position = position.Subtract(orientation.toUnitVector(orientation));

        }

        position = position.LowerLeft(new Vector2d(4,4));
        position = position.UpperRight(new Vector2d(0,0));

    }



}

