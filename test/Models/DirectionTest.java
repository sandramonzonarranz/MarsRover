package Models;

import org.junit.Assert;
import org.junit.Test;

public class DirectionTest {

	// Tests for coordinates relative positions
	@Test
	public void nBetweenWAndE(){
		Direction n = Direction.W.turnRight();
		Assert.assertEquals(Direction.N, n);
		n = Direction.E.turnLeft();
		Assert.assertEquals(Direction.N, n);
	}
	
	@Test
	public void eBetweenNAndS(){
		Direction e = Direction.N.turnRight();
		Assert.assertEquals(Direction.E, e);
		e = Direction.S.turnLeft();
		Assert.assertEquals(Direction.E, e);
	}
	
	@Test
	public void sBetweenEAndW(){
		Direction s = Direction.E.turnRight();
		Assert.assertEquals(Direction.S, s);
		s = Direction.W.turnLeft();
		Assert.assertEquals(Direction.S, s);
	}
	
	@Test
	public void wBetweenSAndN(){
		Direction w = Direction.S.turnRight();
		Assert.assertEquals(Direction.W, w);
		w = Direction.N.turnLeft();
		Assert.assertEquals(Direction.W, w);
	}
	
	
    // Test coordinates XY positions
    @Test
    public void nInXY() {
        int posX = Direction.N.getX();
        int posY = Direction.N.getY();

        Assert.assertEquals(0, posX);
        Assert.assertEquals(1, posY);
    }

    @Test
    public void eInXY() {
        int posX = Direction.E.getX();
        int posY = Direction.E.getY();

        Assert.assertEquals(1, posX);
        Assert.assertEquals(0, posY);
    }
    
    @Test
    public void sInXY() {
        int posX = Direction.S.getX();
        int posY = Direction.S.getY();

        Assert.assertEquals(0, posX);
        Assert.assertEquals(-1, posY);
    }
    
    @Test
    public void wInXY() {
        int posX = Direction.W.getX();
        int posY = Direction.W.getY();

        Assert.assertEquals(-1, posX);
        Assert.assertEquals(0, posY);
    }
}
