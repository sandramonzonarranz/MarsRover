package commands;

import main.MarsRover;

public class TurnLeftCommand implements Command {
	
	 @Override
	 public void run(final MarsRover rover) {
	    rover.turnLeft();
	 }

}
