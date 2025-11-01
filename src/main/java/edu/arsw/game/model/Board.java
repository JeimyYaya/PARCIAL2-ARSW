package edu.arsw.game.model;

public class Board{
    private int rows;
    private int cols;
    private String[][] grid;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        grid = new String[rows][cols];
    }

    public int getRows() {
        return rows;
    }
    public int getCols() {
        return cols;
    }
    public String[][] getGrid() {
        return grid;
    }
    
}
