package commands;

import main.MarsRover;

public class MoveCommand implements Command{
	
    @Override
    public void run(final MarsRover rover) {
        rover.move();
    }

}
