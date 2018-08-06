package models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import models.Coordinates;
import models.Plateau;


public class PlateauTest {

    private Plateau plateau;
    
    @Before
	public void beforeTest() {
		plateau = new Plateau(5,5);
	}
    
    @Test
    public void plateauXRightOutTest() {
        Coordinates coordinates = new Coordinates(6, 0);
        Assert.assertFalse(plateau.isIn(coordinates));
    }

    @Test
    public void plateauXLeftOutTest() {
        Coordinates coordinates = new Coordinates(-1, 0);
        Assert.assertFalse(plateau.isIn(coordinates));
    }

    @Test
    public void plateauYUpOutTest() {
        Coordinates coordinates = new Coordinates(0, 6);
        Assert.assertFalse(plateau.isIn(coordinates));
    }

    @Test
    public void plateauYDownOutTest() {
        Coordinates coordinates = new Coordinates(0, -1);
        Assert.assertFalse(plateau.isIn(coordinates));
    }
    
    @Test
    public void plateauXYPostionIn() {
        Coordinates plateauCoordinates = new Coordinates(5, 0);
        Assert.assertTrue(plateau.isIn(plateauCoordinates));
    }
}
