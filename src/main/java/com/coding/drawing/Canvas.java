package com.coding.drawing;

import java.util.Arrays;
import static com.coding.drawing.Constants.*;

public class Canvas {
    private int width;
    private int height;
    private char[][] canvas;

    public Canvas(int w, int h) {
        this.width = w;
        this.height = h;
        this.canvas = new char[h][w];
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

    public void fillCell(int r, int c){
        if(insideBoundaries(r,c)){
            canvas[r][c] = CELL_DEFAULT_CHARACTER;
        }
    }

    public void fillCell(int r, int c, char custom){
        if(insideBoundaries(r,c)){
            canvas[r][c] = custom;
        }
    }

    private boolean insideBoundaries(int r, int c){
        return r >= 0 && r < height && c >= 0 && c < width;
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
