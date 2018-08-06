package commands;

import org.junit.Assert;
import org.junit.Test;

import commands.TurnRightCommand;
import main.MarsRover;
import models.Coordinates;
import models.Direction;
import models.Plateau;

public class TurnRightCommandTest {
	
    @Test
    public void turnRightTest() {
	    TurnRightCommand command = new TurnRightCommand();
        MarsRover marsRover = new MarsRover(new Plateau(5,5), Direction.N, new Coordinates(1,1));
        command.run(marsRover);
        Assert.assertEquals("1 1 E", marsRover.currentLocation());
    }
}
