package com.coding.drawing;

import com.coding.drawing.commands.BucketFillCommand;
import com.coding.drawing.commands.CreateCommand;
import com.coding.drawing.commands.DrawCommand;
import com.coding.drawing.commands.Type;

public class CommandService {

    public Object parseCommand(String command){
        String[] tokens = command.split(" ");
        String s = tokens[0];
        if(s == null){
            throw new IllegalArgumentException("Invalid command.");
        }

        switch (s) {
            case "C":
                return handleCreateCommand(tokens[1], tokens[2]);
            case "L":
                return handleLineCommand(tokens[1], tokens[2], tokens[3], tokens[4]);
            case "R":
                return handleRectangleCommand(tokens[1], tokens[2], tokens[3], tokens[4]);
            case "B":
                return handleBucketFillCommand(tokens[1], tokens[2], tokens[3]);
            default:
                throw new IllegalArgumentException("Invalid command.");
        }
    }

    private CreateCommand handleCreateCommand(String w, String h){
        if(w == null || h == null) throw new IllegalArgumentException("Invalid create command.");
        int width = Integer.parseInt(w);
        int height = Integer.parseInt(h);
        if(width <= 2 || height <= 2){
            throw new IllegalArgumentException("Invalid create command.");
        }
        return new CreateCommand(width, height);
    }

    private DrawCommand handleLineCommand(String r1, String c1, String r2, String c2){
        if(r1 == null || c1 == null || r2 == null || c2 == null)
            throw new IllegalArgumentException("Invalid line command.");
        return new DrawCommand(Type.LINE, Integer.parseInt(r1), Integer.parseInt(c1),
                Integer.parseInt(r2), Integer.parseInt(c2));
    }

    private DrawCommand handleRectangleCommand(String r1, String c1, String r2, String c2){
        if(r1 == null || c1 == null || r2 == null || c2 == null)
            throw new IllegalArgumentException("Invalid rectangle command.");
        return new DrawCommand(Type.RECTANGLE, Integer.parseInt(r1), Integer.parseInt(c1),
            Integer.parseInt(r2), Integer.parseInt(c2));
    }

    private BucketFillCommand handleBucketFillCommand(String r1, String c1, String character){
        if(character.length() != 1){
            throw new IllegalArgumentException("Invalid bucket fill command.");
        }
        return new BucketFillCommand(Integer.parseInt(r1), Integer.parseInt(c1), character.charAt(0));
    }
}
