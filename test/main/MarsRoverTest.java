package main;

import org.junit.Assert;
import org.junit.Test;

import main.MarsRover;
import models.Coordinates;
import models.Direction;
import models.Plateau;

public class MarsRoverTest {

    @Test
    public void turnLeftTest() {
        MarsRover marsRover = new MarsRover(new Plateau(5,5), Direction.N, new Coordinates(1,1));
        marsRover.turnLeft();
        Assert.assertEquals("1 1 W", marsRover.currentLocation());
    }

    @Test
    public void turnRightTest() {
        MarsRover marsRover = new MarsRover(new Plateau(5,5), Direction.N, new Coordinates(1,1));
        marsRover.turnRight();
        Assert.assertEquals("1 1 E", marsRover.currentLocation());
    }

    @Test
    public void moveTest() {
    	 MarsRover marsRover = new MarsRover(new Plateau(5,5), Direction.N, new Coordinates(1,1));
	     marsRover.move();
	     Assert.assertEquals("1 2 N", marsRover.currentLocation());
    }

    @Test
    public void runTurnRightTest() {
        MarsRover marsRover = new MarsRover(new Plateau(5,5), Direction.N, new Coordinates(1,1));
        marsRover.run("R");
        Assert.assertEquals("1 1 E", marsRover.currentLocation());
    }

    @Test
    public void runTurnLeftTest() {
        MarsRover marsRover = new MarsRover(new Plateau(5,5), Direction.N, new Coordinates(1,1));
        marsRover.run("L");
        Assert.assertEquals("1 1 W", marsRover.currentLocation());
    }

    @Test
    public void runMoveTest() {
        MarsRover marsRover = new MarsRover(new Plateau(5,5), Direction.N, new Coordinates(1,1));
        marsRover.run("M");
        Assert.assertEquals("1 2 N", marsRover.currentLocation());
    }

    @Test
    public void runMultipleTest() {
        MarsRover marsRover = new MarsRover(new Plateau(5,5), Direction.N, new Coordinates(1,1));
        marsRover.run("MRL");
        Assert.assertEquals("1 2 N", marsRover.currentLocation());
    }

    @Test
    public void runInfiniteTest() {
    	 MarsRover marsRover = new MarsRover(new Plateau(5,5), Direction.N, new Coordinates(1,1));
	     marsRover.run("MMMMMMMMMM");
         Assert.assertEquals("1 5 N", marsRover.currentLocation());
    }
    
    @Test
    public void input1Test(){
    	Coordinates startingPosition = new Coordinates(1,2);
		MarsRover marsRover = new MarsRover(new Plateau(5,5), Direction.N, startingPosition);;
		marsRover.run("LMLMLMLMM");
		Assert.assertEquals("1 3 N", marsRover.currentLocation());
    }
    
    @Test
    public void input2Test(){
    	Coordinates startingPosition = new Coordinates(3,3);
    	MarsRover marsRover = new MarsRover(new Plateau(5,5), Direction.E, startingPosition);
    	marsRover.run("MMRMMRMRRM");
		Assert.assertEquals("5 1 E", marsRover.currentLocation());
    }
    
}
