package grid;

import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GridMaker{

	int rows;
	int columns;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	double height = screenSize.getHeight() - screenSize.getHeight()*0.2;
	Grid grid;
	
	
	public StackPane drawGrid(int row, int column) {
		this.rows = row;
		this.columns = column;
		grid  = new Grid(rows, columns, width, height);
		StackPane layout = new StackPane();
		CellEvent event = new CellEvent();

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				Cell cell = new Cell(i, j);
				event.colorCell(cell);
				grid.addCell(cell, i, j);
				Vertex vertex = new Vertex(i,j);
				grid.adjacentCells(vertex);
				cell.addVertex(vertex);
			}
		}

		layout.getChildren().addAll(grid);
		return layout;
	}
	
	public Grid getGrid() {
		return grid;
	}
}
