package agh.ics.oop;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

public class GrassField extends AbstractWorldMap{

    private HashMap<Vector2d, Grass> grassHashMap = new HashMap<>();

    public GrassField(int n) {
        layOutGrass(n);
    }

    public void layOutGrass(int n){
        Random r = new Random();
        for(int i = 0; i< n; i++){
            int x = r.nextInt((int) Math.sqrt(n*10) + 1);
            int y = r.nextInt((int) Math.sqrt(n*10) + 1);
            if(isOccupied(new Vector2d(x, y))){
                i--;
            }
            else {
                grassHashMap.put(new Vector2d(x, y), new Grass(new Vector2d(x, y)));
            }
        }
    }

    public void addGrass(Vector2d position){
        grassHashMap.put(position, new Grass(position));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(this.objectAt(position) instanceof Animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    protected Vector2d getLeftLowerCorner(){
        Vector2d lowerBound = new Vector2d(99999, 99999);
        for(Vector2d tmpPosition: grassHashMap.keySet()){
            lowerBound = lowerBound.LowerLeft(tmpPosition);
        }
        for(Vector2d tmpPosition: animalsHashMap.keySet()){
            lowerBound = lowerBound.LowerLeft(tmpPosition);
        }
        return lowerBound;
    }
    @Override
    protected Vector2d getRightHigherCorner(){
        Vector2d upperBound = new Vector2d(-99999, -99999);
        for(Vector2d tmpPosition: grassHashMap.keySet()){
            upperBound = upperBound.UpperRight(tmpPosition);
        }
        for(Vector2d tmpPosition: animalsHashMap.keySet()){
            upperBound = upperBound.UpperRight(tmpPosition);
        }
        return upperBound;
    }
    @Override
    public Object objectAt(Vector2d position) {

        Object objectTmp = super.objectAt(position);

        if(objectTmp != null) {return objectTmp;}

        if(grassHashMap.get(position) != null) {return grassHashMap.get(position);}

        return null;
    }

    public void deleteGrass(Vector2d position) {
        if(grassHashMap.get(position) != null){
            layOutGrass(1);
            grassHashMap.remove(position);
        }
    }

}