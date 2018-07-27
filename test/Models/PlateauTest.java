package Models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PlateauTest {

    private Plateau plateau;
    
    @Before
	public void beforeTest() {
		plateau = new Plateau(5,5);
	}
    
    @Test
    public void plateauXRightOut() {
        Coordinates coordinates = new Coordinates(6, 0);
        Assert.assertFalse(plateau.isIn(coordinates));
    }

    @Test
    public void plateauXLeftOut() {
        Coordinates coordinates = new Coordinates(-1, 0);
        Assert.assertFalse(plateau.isIn(coordinates));
    }

    @Test
    public void plateauYUpOut() {
        Coordinates coordinates = new Coordinates(0, 6);
        Assert.assertFalse(plateau.isIn(coordinates));
    }

    @Test
    public void plateauYDownOut() {
        Coordinates coordinates = new Coordinates(0, -1);
        Assert.assertFalse(plateau.isIn(coordinates));
    }
    
    @Test
    public void plateauXYPostionIn() {
        Coordinates plateauCoordinates = new Coordinates(5, 0);
        Assert.assertTrue(plateau.isIn(plateauCoordinates));
    }
}
