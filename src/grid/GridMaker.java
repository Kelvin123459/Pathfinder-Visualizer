package grid;

import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GridMaker{

	int rows = 20;
	int columns = 20;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	double height = screenSize.getHeight() - screenSize.getHeight()*0.2;
	Grid grid = new Grid(rows, columns, width, height);
	
	public StackPane drawGrid() {
		StackPane layout = new StackPane();
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
	
	public Grid getGrid() {
		return grid;
	}
}
