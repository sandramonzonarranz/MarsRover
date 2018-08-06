package models;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import models.Coordinates;

public class CoordinatesTest {

    private Coordinates coordinates;
    
    @Before
	public void beforeTest() {
    	coordinates = new Coordinates(5,5);
	}
    

    @Test
    public void moveNewCooordinates() {
        Coordinates newBoundary = coordinates.moveCoordinates(1, -1);
        Assert.assertEquals("6 4", newBoundary.toString());
        Assert.assertEquals("5 5", coordinates.toString());
    }
    
    @Test
    public void moveXPositiveTest() {
        coordinates = coordinates.moveCoordinates(1, 0);
        Assert.assertEquals("6 5", coordinates.toString());
    }

    @Test
    public void moveXNegativeTest() {
    	coordinates = coordinates.moveCoordinates(-1, 0);
        Assert.assertEquals("4 5", coordinates.toString());
    }

    @Test
    public void moveYPositiveTest() {
    	coordinates = coordinates.moveCoordinates(0, 1);
        Assert.assertEquals("5 6", coordinates.toString());
    }

    @Test
    public void moveYNegativeTest() {
    	coordinates = coordinates.moveCoordinates(0, -1);
        Assert.assertEquals("5 4", coordinates.toString());
    }

    @Test
    public void pointXInside() {
        Coordinates inPoint = new Coordinates(4,5);
        Assert.assertTrue(coordinates.isIn(inPoint));
    }

    @Test
    public void pointYInside() {
        Coordinates inPoint = new Coordinates(5,4);
        Assert.assertTrue(coordinates.isIn(inPoint));
    }


    @Test
    public void pointXOut() {
        Coordinates outPoint = new Coordinates(6,5);
        Assert.assertTrue(coordinates.isOut(outPoint));
    }

    @Test
    public void pointYOut() {
        Coordinates outPoint = new Coordinates(5,6);
        Assert.assertTrue(coordinates.isOut(outPoint));
    }
    
    @Test
	public void toStringTest() {
		assertEquals(coordinates.toString(), coordinates.getX() + " " + coordinates.getY());
	}
}
