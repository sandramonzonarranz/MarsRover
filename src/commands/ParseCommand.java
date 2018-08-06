package commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ParseCommand {

    public static final String BY_EACH_CHARACTER = "";

    @SuppressWarnings("serial")
	private static Map<String, Command> stringToCommandMap = new HashMap<String, Command>() {{
        put("L", new TurnLeftCommand());
        put("R", new TurnRightCommand());
        put("M", new MoveCommand());
    }};

    @Getter @Setter
    private String command;

    public List<Command> toCommands() {
    	List<Command> commands = new ArrayList<Command>();
        if(isNullOrEmpty(command)) return commands;
        for(String commandCharacter : commandCharactersFrom(command)) {
            if (commandCharacter == null) break;
            commands.add(stringToCommandMap.get(commandCharacter.toUpperCase()));
        }

        return commands;
    }

    private boolean isNullOrEmpty(final String commandString) {
        return (null == commandString || commandString.trim().length() == 0);
    }

    private String[] commandCharactersFrom(final String commandString) {
        return Arrays.copyOfRange(commandString.split(BY_EACH_CHARACTER), 0, commandString.length() + 1);
    }

}