package agh.ics.oop;

import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

public class GrassField extends AbstractWorldMap{

    private final ArrayList<Grass> grassList = new ArrayList<>();

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
                grassList.add(new Grass(new Vector2d(x, y)));
            }
        }
    }

    public void addGrass(Vector2d position){
        grassList.add(new Grass(position));
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
        for(Grass grass: grassList){
            lowerBound = lowerBound.LowerLeft(grass.getPosition());
        }
        for(Animal animal:animalList){
            lowerBound = lowerBound.LowerLeft(animal.getPosition());
        }
        return lowerBound;
    }
    @Override
    protected Vector2d getRightHigherCorner(){
        Vector2d upperBound = new Vector2d(-99999, -99999);
        for(Grass grass: grassList){
            upperBound = upperBound.UpperRight(grass.getPosition());
        }
        for(Animal animal:animalList){
            upperBound = upperBound.UpperRight(animal.getPosition());
        }
        return upperBound;
    }
    @Override
    public Object objectAt(Vector2d position) {

        Object objectTmp = super.objectAt(position);

        if(objectTmp != null) {return objectTmp;}

        for(Grass grass: grassList){
            if(grass.getPosition().equals(position)) {return grass;}
        }
        return null;
    }
    private Grass grassAt(Vector2d position) {
        for (Grass grass : grassList) {
            if (grass.getPosition().equals(position)) {return grass;}
        }
        return null;
    }

    public void deleteGrass(Vector2d position) {
        if(grassAt(position) != null){
            layOutGrass(1);
            grassList.remove(this.grassAt(position));
        }
    }

}