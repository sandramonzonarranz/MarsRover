package commands;

import org.junit.Assert;
import org.junit.Test;

import commands.MoveCommand;
import main.MarsRover;
import models.Coordinates;
import models.Direction;
import models.Plateau;

public class MoveCommandTest {

	@Test
    public void moveTest() {
        MoveCommand command = new MoveCommand();
        MarsRover marsRover = new MarsRover(new Plateau(5,5), Direction.N, new Coordinates(1,1));
        command.run(marsRover);
        Assert.assertEquals("1 2 N", marsRover.currentLocation());
    }
}
