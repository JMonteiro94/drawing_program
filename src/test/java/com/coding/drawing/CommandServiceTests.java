package com.coding.drawing;

import com.coding.drawing.commands.BucketFillCommand;
import com.coding.drawing.commands.CreateCommand;
import com.coding.drawing.commands.DrawCommand;
import com.coding.drawing.commands.Type;
import org.junit.Test;

public class CommandServiceTests {

    private CommandService commandService = new CommandService();

    @Test
    public void createCommand() {
        Object createCommand = commandService.parseCommand("C 20 4");
        assert(createCommand instanceof CreateCommand);
        assert(((CreateCommand) createCommand).getWidth() == 20);
        assert(((CreateCommand) createCommand).getHeight() == 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidCreateCommand() {
        commandService.parseCommand("C 2");
    }

    @Test
    public void lineCommand() {
        Object lineCommand = commandService.parseCommand("L 1 2 6 2");
        assert(lineCommand instanceof DrawCommand);
        assert(((DrawCommand) lineCommand).getType() == Type.LINE);
        assert(((DrawCommand) lineCommand).getStartColumn() == 1);
        assert(((DrawCommand) lineCommand).getStartRow() == 2);
        assert(((DrawCommand) lineCommand).getEndColumn() == 6);
        assert(((DrawCommand) lineCommand).getEndRow() == 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidLineCommand() {
        commandService.parseCommand("L 1 2");
    }

    @Test
    public void rectangleCommand() {
        Object lineCommand = commandService.parseCommand("R 16 1 20 3");
        assert(lineCommand instanceof DrawCommand);
        assert(((DrawCommand) lineCommand).getType() == Type.RECTANGLE);
        assert(((DrawCommand) lineCommand).getStartColumn() == 16);
        assert(((DrawCommand) lineCommand).getStartRow() == 1);
        assert(((DrawCommand) lineCommand).getEndColumn() == 20);
        assert(((DrawCommand) lineCommand).getEndRow() == 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidRectangleCommand() {
        commandService.parseCommand("R 16 1");
    }

    @Test
    public void bucketFillCommand() {
        Object lineCommand = commandService.parseCommand("B 10 3 o");
        assert(lineCommand instanceof BucketFillCommand);
        assert(((BucketFillCommand) lineCommand).getColumn() == 10);
        assert(((BucketFillCommand) lineCommand).getRow() == 3);
        assert(((BucketFillCommand) lineCommand).getColour() == 'o');
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidBucketFillCommand() {
        commandService.parseCommand("B 10");
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidBucketFillCommandWhenCellColumnIsZero() {
        commandService.parseCommand("B 0 1 o");
    }
}
