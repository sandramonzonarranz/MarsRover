package commands;

import main.MarsRover;

public class TurnRightCommand implements Command {
	
	 @Override
	    public void run(final MarsRover rover) {
	        rover.turnRight();
	    }
}
