package agh.ics.oop;


public class RectangularMap extends AbstractWorldMap{

    private final int width;
    private final int height;
    public static final Vector2d LOWER_BOUND = new Vector2d(0,0); //takie nasze wprowadzone stale, moga byc prywatne

    public RectangularMap(int height, int width) {
        this.width = height-1;
        this.height = width-1;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.Follows(LOWER_BOUND) &&
                position.Precedes(new Vector2d(width,height)) && !isOccupied(position);
    }


    @Override

    protected Vector2d getLeftLowerCorner(){
        return LOWER_BOUND;
    }
    @Override
    protected Vector2d getRightHigherCorner(){
        return new Vector2d(width,height);
    }

    @Override
    public void moved(Vector2d position) {}

}