package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTests {

    @Test
    void objectAtTest() {

        //given
        GrassField map = new GrassField(0);

        Vector2d animalPosition = new Vector2d(2, 2);
        Vector2d grassPosition = new Vector2d(4, 4);
        Vector2d emptyPosition = new Vector2d(6, 6);

        Animal animal = new Animal(map, animalPosition);
        Animal animalOnGrass = new Animal(map, grassPosition);

        //when
        map.addGrass(grassPosition);
        map.place(animal);

        //then
        assertNull(map.objectAt(emptyPosition));
        assertTrue(map.objectAt(grassPosition)  instanceof Grass);
        assertTrue(map.objectAt(animalPosition) instanceof Animal);

        //Returns animal before grass
        map.place(animalOnGrass);
        assertTrue(map.objectAt(grassPosition) instanceof Animal);

        assertFalse(map.canMoveTo(animalPosition));
        assertTrue(map.canMoveTo(grassPosition));
        assertTrue(map.canMoveTo(emptyPosition));

        assertTrue(map.isOccupied(animalPosition));
        assertTrue(map.isOccupied(grassPosition));
        assertFalse(map.isOccupied(emptyPosition));

        assertTrue(map.objectAt(grassPosition) instanceof Grass);
        map.moved(grassPosition);
        assertNull(map.objectAt(grassPosition));
    }


}