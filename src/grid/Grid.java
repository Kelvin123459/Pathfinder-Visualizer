package grid;

import javafx.scene.layout.Pane;

public class Grid extends Pane {

    int rows;
    int columns;

    double width;
    double height;

    Cell[][] cells;

    public Grid(int rows, int columns, double width, double height) {
        this.columns = columns;
        this.rows = rows;
        this.width = width;
        this.height = height;
        cells = new Cell[rows][columns];
    }

    public void addCell(Cell cell, int row, int column) {
        cells[row][column] = cell;
        double prefWidth = width / columns;
        double prefHeight = height / rows;
        double x = prefWidth * column;
        double y = prefHeight * row;

        cell.setLayoutX(x);
        cell.setLayoutY(y);
        cell.setPrefWidth(prefWidth);
        cell.setPrefHeight(prefHeight);
        getChildren().add(cell);
    }
    
    public Cell getCell(int column, int row) {
        return cells[row][column];
    }
    
    
}