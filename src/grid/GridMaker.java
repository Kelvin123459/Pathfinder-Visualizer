package grid;

import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.scene.layout.StackPane;

public class GridMaker {
	int rows;
	int columns;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	double height = screenSize.getHeight() - screenSize.getHeight()*0.2;
	Grid grid;
	CellEvent event;
	
	
	public StackPane drawGrid(int row, int column) {
		this.rows = row;
		this.columns = column;
		grid  = new Grid(rows, columns, width, height);
		StackPane layout = new StackPane();
		event = new CellEvent();

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				Vertex vertex = new Vertex(i, j);
				event.colorCell(vertex);
				grid.addCell(vertex, i, j);
			}
		}

		layout.getChildren().addAll(grid);
		return layout;
	}
	
	public Grid getGrid() {
		return grid;
	}
	
	public CellEvent getCellEvent() {
		return event;
	}
}
