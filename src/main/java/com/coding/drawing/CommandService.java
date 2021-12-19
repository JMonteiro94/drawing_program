package com.coding.drawing;

import com.coding.drawing.commands.BucketFillCommand;
import com.coding.drawing.commands.CreateCommand;
import com.coding.drawing.commands.DrawCommand;
import com.coding.drawing.commands.Type;

public class CommandService {

    public Object parseCommand(String command){
        String[] tokens = command.split(" ");
        if(tokens.length == 0) throw new IllegalArgumentException("Invalid command.");
        String s = tokens[0];

        switch (s) {
            case "C":
                if(tokens.length < 3) throw new IllegalArgumentException("Invalid create command.");
                return handleCreateCommand(tokens[1], tokens[2]);
            case "L":
                if(tokens.length < 5) throw new IllegalArgumentException("Invalid line command.");
                return handleLineCommand(tokens[1], tokens[2], tokens[3], tokens[4]);
            case "R":
                if(tokens.length < 5) throw new IllegalArgumentException("Invalid rectangle command.");
                return handleRectangleCommand(tokens[1], tokens[2], tokens[3], tokens[4]);
            case "B":
                if(tokens.length < 4) throw new IllegalArgumentException("Invalid bucket fill command.");
                return handleBucketFillCommand(tokens[1], tokens[2], tokens[3]);
            default:
                throw new IllegalArgumentException("Invalid command.");
        }
    }

    private CreateCommand handleCreateCommand(String w, String h){
        int width = Integer.parseInt(w);
        int height = Integer.parseInt(h);
        if(width < 1 || height < 1){
            throw new IllegalArgumentException("Invalid create command.");
        }
        return new CreateCommand(width, height);
    }

    private DrawCommand handleLineCommand(String r1, String c1, String r2, String c2){
        int row1 = Integer.parseInt(r1);
        int col1 = Integer.parseInt(c1);
        int row2 = Integer.parseInt(r2);
        int col2 = Integer.parseInt(c2);
        if(row1 < 1 || col1 < 1 || row2 < 1 || col2 < 1)
            throw new IllegalArgumentException("Invalid line command.");
        return new DrawCommand(Type.LINE,row1, col1, row2, col2);
    }

    private DrawCommand handleRectangleCommand(String r1, String c1, String r2, String c2){
        int row1 = Integer.parseInt(r1);
        int col1 = Integer.parseInt(c1);
        int row2 = Integer.parseInt(r2);
        int col2 = Integer.parseInt(c2);
        if(row1 < 1 || col1 < 1 || row2 < 1 || col2 < 1)
            throw new IllegalArgumentException("Invalid rectangle command.");
        return new DrawCommand(Type.RECTANGLE, row1, col1, row2, col2);
    }

    private BucketFillCommand handleBucketFillCommand(String r, String c, String character){
        int row = Integer.parseInt(r);
        int col = Integer.parseInt(c);
        if(row < 1 || col < 1 || character.length() != 1){
            throw new IllegalArgumentException("Invalid bucket fill command.");
        }
        return new BucketFillCommand(row, col, character.charAt(0));
    }
}
