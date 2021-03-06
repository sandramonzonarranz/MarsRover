package commands;

import org.junit.Assert;
import org.junit.Test;

import commands.TurnLeftCommand;
import main.MarsRover;
import models.Coordinates;
import models.Direction;
import models.Plateau;

public class TurnLeftCommandTest {
	
    @Test
    public void turnLeftTest() {
	    TurnLeftCommand command = new TurnLeftCommand();
        MarsRover marsRover = new MarsRover(new Plateau(5,5), Direction.N, new Coordinates(1,1));
        command.run(marsRover);
        Assert.assertEquals("1 1 W", marsRover.currentLocation());
    }
}
