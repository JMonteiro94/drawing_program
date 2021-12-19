package com.coding.drawing.commands;

public class BucketFillCommand {
    private Type type;
    private Cell cell;
    private char c;

    public BucketFillCommand(int c1, int r1, char c) {
        this.type = Type.BUCKET_FILL;
        this.cell = new Cell(r1, c1);
        this.c = c;
    }

    public int getRow() {
        return cell.getRow();
    }

    public int getColumn() {
        return cell.getColumn();
    }

    public char getCharacterToFill() {
        return c;
    }
}
