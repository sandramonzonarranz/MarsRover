package commands;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import commands.Command;
import commands.MoveCommand;
import commands.ParseCommand;
import commands.TurnLeftCommand;
import commands.TurnRightCommand;

public class ParseCommandsTest {

    @Test
    public void nullCommandTest() {
    	 ParseCommand parser = new ParseCommand(null);
         List<Command> commands = parser.toCommands();
         Assert.assertEquals(0, commands.size());

    }

    @Test
    public void emptyCommandTest() {
       ParseCommand parser = new ParseCommand("");
       List<Command> commands = parser.toCommands();
       Assert.assertEquals(0, commands.size());
    }

    @Test
    public void caseCommandTest() {
    	ParseCommand parser = new ParseCommand("m");
        List<Command> commands = parser.toCommands();
        Assert.assertTrue(commands.get(0) instanceof MoveCommand);
    }

    @Test
    public void parseMCommandTest() {
        ParseCommand parser = new ParseCommand("M");
        List<Command> commands = parser.toCommands();
        Assert.assertTrue(commands.get(0) instanceof MoveCommand);
        Assert.assertEquals(1, commands.size());
    }
    
    @Test
    public void parseRCommandTest() {
        ParseCommand parser = new ParseCommand("R");
        List<Command> commands = parser.toCommands();
        Assert.assertTrue(commands.get(0) instanceof TurnRightCommand);
        Assert.assertEquals(1, commands.size());
    }
    
    @Test
    public void parseLCommandTest() {
        ParseCommand parser = new ParseCommand("L");
        List<Command> commands = parser.toCommands();
        Assert.assertTrue(commands.get(0) instanceof TurnLeftCommand);
        Assert.assertEquals(1, commands.size());
    }

    @Test
    public void multipleCommandTest() {
    	ParseCommand parser = new ParseCommand("MRL");
        List<Command> commands = parser.toCommands();
        Assert.assertTrue(commands.get(0) instanceof MoveCommand);
        Assert.assertTrue(commands.get(1) instanceof TurnRightCommand);
        Assert.assertTrue(commands.get(2) instanceof TurnLeftCommand);
    }

}