package com.coding.drawing.commands;

public class DrawCommand {
    private Type type;
    private Cell start;
    private Cell end;

    public DrawCommand(Type type, int c1, int r1, int c2, int r2) {
        this.type = type;
        this.start = new Cell(r1,c1);
        this.end = new Cell(r2, c2);
    }

    public int getStartRow() {
        return start.getRow();
    }

    public int getStartColumn() {
        return start.getColumn();
    }

    public int getEndRow() {
        return end.getRow();
    }

    public int getEndColumn() {
        return end.getColumn();
    }

    public Type getType() {
        return type;
    }
}
