package com.coding.drawing;

import com.coding.drawing.commands.BucketFillCommand;
import com.coding.drawing.commands.CreateCommand;
import com.coding.drawing.commands.DrawCommand;
import com.coding.drawing.commands.Type;

public class CanvasUpdateService {

    private CommandService commandService = new CommandService();
    private Canvas canvas = null;

    public void newCommand(String commandLine) {
        try {
            Object command = commandService.parseCommand(commandLine);
            if(command instanceof CreateCommand){
                CreateCommand createCommand = (CreateCommand) command;
                canvas = new Canvas(createCommand.getWidth(), createCommand.getHeight());
            } else if(command instanceof DrawCommand){
                if(canvas == null) throw new IllegalArgumentException("Canvas has not been initialized.");
                DrawCommand drawCommand = (DrawCommand) command;
                if(Type.LINE == drawCommand.getType()){
                    canvas.drawLine(drawCommand.getStartRow(), drawCommand.getEndRow(),
                            drawCommand.getStartColumn(), drawCommand.getEndColumn());
                } else if(Type.RECTANGLE == drawCommand.getType()){
                    canvas.drawRectangle(drawCommand.getStartRow(), drawCommand.getStartColumn(),
                            drawCommand.getEndRow(), drawCommand.getEndColumn());
                }
            } else if(command instanceof BucketFillCommand){
                if(canvas == null) throw new IllegalArgumentException("Canvas has not been initialized.");
                BucketFillCommand bucketFillCommand = (BucketFillCommand) command;
                canvas.bucketFill(bucketFillCommand.getRow(), bucketFillCommand.getColumn(),
                        bucketFillCommand.getColour());
            }
            canvas.printCanvas();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
