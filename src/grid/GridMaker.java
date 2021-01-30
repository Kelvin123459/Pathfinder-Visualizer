package grid;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GridMaker{

	int rows = 20;
	int columns = 20;
	double width = 800;
	double height = 600;
	
	public StackPane drawGrid() {
		StackPane layout = new StackPane();
		Grid grid = new Grid(rows, columns, width, height);
		CellEvent event = new CellEvent();

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				Cell cell = new Cell(i, j);
				event.colorCell(cell);
				grid.addCell(cell, i, j);
			}
		}

		layout.getChildren().addAll(grid);
		return layout;
	}
}
