package com.coding.drawing;

import java.util.Arrays;
import static com.coding.drawing.Constants.*;

public class Canvas {
    private int width;
    private int height;
    private char[][] canvas;

    public Canvas(int w, int h) {
        this.width = w + 2;
        this.height = h + 2;
        this.canvas = new char[this.height][this.width];
        fillBoundaries();
    }

    private void fillBoundaries(){
        fillAllCellsWithSpace();
        fillRowWithDefaultChar(0);
        fillRowWithDefaultChar(height - 1);
        fillColumnWithDefaultChar(0);
        fillColumnWithDefaultChar(width - 1);
    }

    private void fillAllCellsWithSpace(){
        for (int r = 0; r < height; r++){
            Arrays.fill(canvas[r], ' ');
        }
    }

    private void fillRowWithDefaultChar(int row){
        for (int c = 0; c < width; c++){
            canvas[row][c] = ROW_DEFAULT_CHARACTER;
        }
    }

    private void fillColumnWithDefaultChar(int column){
        for (int r = 1; r < height - 1; r++){
            canvas[r][column] = COLUMN_DEFAULT_CHARACTER;
        }
    }

    private boolean insideBoundaries(int r, int c){
        return r >= 1 && r < height - 1 && c >= 1 && c < width - 1;
    }

    public void drawLine(int startRow, int endRow, int startColumn, int endColumn){
        if(!insideBoundaries(startRow, startColumn) || !insideBoundaries(endRow, endColumn)){
            throw new IllegalArgumentException("Invalid command.");
        }
        for(int r = startRow; r <= endRow; r++){
            for (int c = startColumn; c <= endColumn; c++){
                canvas[r][c] = CELL_DEFAULT_CHARACTER;
            }
        }
    }

    public void drawRectangle(int startRow, int startColumn, int endRow, int endColumn){
        if(!insideBoundaries(startRow, startColumn) || !insideBoundaries(endRow, endColumn)){
            throw new IllegalArgumentException("Invalid command.");
        }
        drawLine(startRow, startRow, startColumn, endColumn);
        drawLine(endRow, endRow, startColumn, endColumn);
        drawLine(startRow, endRow, startColumn, startColumn);
        drawLine(startRow, endRow, endColumn, endColumn);
    }

    public void bucketFill(int row, int column, char colour){
        if(!insideBoundaries(row, column)){
            throw new IllegalArgumentException("Invalid command.");
        }
        int[][] neighbors = {{1,0},{0,1},{-1,0},{0,-1}};
        dfs(row, column, colour, neighbors);
    }

    private void dfs(int row, int column, char colour, int[][] neighbors){
        if(!insideBoundaries(row, column) || canvas[row][column] != ' '){
            return;
        }

        canvas[row][column] = colour;
        for(int[] neighbor : neighbors){
            int r = row + neighbor[0];
            int c = column + neighbor[1];
            dfs(r, c, colour, neighbors);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(width * height);
        for (int row = 0; row < height; row++){
            for (int col = 0; col < width; col++){
                sb.append(canvas[row][col]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void printCanvas(){
        System.out.println(this);
    }
}
