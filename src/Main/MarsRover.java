package Main;

import java.util.List;

import Commands.Command;
import Commands.ParseCommand;
import Models.Plateau;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import Models.Direction;
import Models.Coordinates;

@NoArgsConstructor
@AllArgsConstructor
public class MarsRover {
	
    private Plateau plateau;
    private Direction direction;
    private Coordinates coordinates;


    public void run(final String commandString) {
        List<Command> roverCommands = new ParseCommand(commandString).toCommands();
        for (Command command : roverCommands) {
            command.run(this);
        }
    }

    public String currentLocation() {
        return coordinates.toString() + " " + direction.toString();
    }

    public void turnRight() {
        this.direction = this.direction.turnRight();
    }

    public void turnLeft() {
        this.direction = this.direction.turnLeft();
    }

    public void move() {
        Coordinates positionAfterMove = coordinates.moveCoordinates(direction.getX(), direction.getY());

        if(plateau.isIn(positionAfterMove)){   // Just ensure is not going Out
            coordinates = coordinates.moveCoordinates(direction.getX(), direction.getY());
        }
    }
}
