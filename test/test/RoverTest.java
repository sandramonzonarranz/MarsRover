package test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.Coordinates;
import main.Direction;
import main.Obstacle;
import main.Rover;
import main.Point;

public class RoverTest {

	private Rover rover;
    private Coordinates roverCoordinates;
    private final Direction direction = Direction.NORTH;
    private Point x;
    private Point y;
    private List<Obstacle> obstacles;

    @Before
    public void beforeTest() {
        x = new Point(1, 9);
        y = new Point(2, 9);
        obstacles = new ArrayList<Obstacle>();
        roverCoordinates = new Coordinates(x, y, direction, obstacles);
        rover = new Rover(roverCoordinates);
    }

    @Test
    public void newInstanceTest() {
    	assertEquals(rover.getCoordinates(), roverCoordinates);
    }

    @Test
    public void commandMTest() throws Exception {
        int expected = y.getPosition() + 1;
        rover.doSingleCommand('M');
        assertEquals(rover.getCoordinates().getY().getPosition(), expected);
    }

    @Test
    public void commandLTest() throws Exception {
        rover.doSingleCommand('L');
        assertEquals(rover.getCoordinates().getDirection(), Direction.WEST);
    }

    @Test
    public void commandRTest() throws Exception {
        rover.doSingleCommand('R');
        assertEquals(rover.getCoordinates().getDirection(), Direction.EAST);
    }

    @Test
    public void comandLowerCaseTest() throws Exception {
        rover.doSingleCommand('r');
        assertEquals(rover.getCoordinates().getDirection(), Direction.EAST);
    }

    @Test(expected = Exception.class)
    public void commandInvalidTest() throws Exception {
        rover.doSingleCommand('X');
    }

    @Test
    public void multipleCommandTest() throws Exception {
    	int expected = x.getPosition() + 1;
        rover.doCommands("RMR");
        assertEquals(rover.getCoordinates().getX().getPosition(), expected);
        assertEquals(rover.getCoordinates().getDirection(), Direction.SOUTH);
    }

    @Test
    public void commandRangeTest() throws Exception {
    	rover.getCoordinates();
        rover.doCommands("LMMM");
        assertEquals(rover.getCoordinates().getX().getPosition(), x.getMaxPosition() - 1);
    }

    @Test
    public void commandStopWhenObstacleTest() throws Exception {
        int expected = x.getPosition() + 1;
        rover.getCoordinates().setObstacles(Arrays.asList(new Obstacle(expected + 1, y.getPosition())));
        rover.getCoordinates().setDirection(Direction.EAST);
        rover.doCommands("MMMRM");
        assertEquals(rover.getCoordinates().getX().getPosition(), expected);
        assertEquals(rover.getCoordinates().getDirection(), Direction.EAST);
    }

    @Test
    public void commandReturnValueTest() throws Exception {
        rover.doCommands("LMR");
        assertEquals(rover.getPosition(), "0 X 2 N");
    }

    @Test
    public void obstacleFoundTest() throws Exception {
        rover.getCoordinates().setObstacles(Arrays.asList(new Obstacle(x.getPosition() + 1, y.getPosition())));
        rover.getCoordinates().setDirection(Direction.EAST);
        rover.doCommands("M");
        assert(rover.getPosition()).endsWith(" NOK");
    }

}
