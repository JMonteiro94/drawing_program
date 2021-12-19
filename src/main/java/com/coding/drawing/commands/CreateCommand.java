package com.coding.drawing.commands;

public class CreateCommand {
    private Type type;
    private int width;
    private int height;

    public CreateCommand(int width, int height) {
        this.type = Type.CREATE;
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
