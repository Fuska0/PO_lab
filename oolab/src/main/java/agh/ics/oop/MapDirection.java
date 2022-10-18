package agh.ics.oop;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public String ToString(MapDirection direction){
        return(switch(direction) {
            case NORTH -> "Północ";
            case SOUTH -> "Południe";
            case WEST -> "Zachód";
            case EAST -> "Wschód";
        });
    }

    public MapDirection next(MapDirection direction){
        return(switch(direction) {
            case NORTH -> EAST;
            case SOUTH -> WEST;
            case WEST -> NORTH;
            case EAST -> SOUTH;
        });
    }

    public MapDirection previous(MapDirection direction){
        return(switch(direction) {
            case NORTH -> WEST;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
            case EAST -> NORTH;
        });
    }

    public Vector2d toUnitVector(MapDirection direction){
        Vector2d v1 = switch(direction) {
            case NORTH -> v1 = new Vector2d(0,1);
            case SOUTH -> v1 = new Vector2d(0,-1);
            case WEST -> v1 = new Vector2d(-1,0);
            case EAST -> v1 = new Vector2d(1,0);
        };
        return(v1);
    }

    //sprawdzam czy push dziala
}
