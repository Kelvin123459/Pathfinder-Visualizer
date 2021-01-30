package grid;

import javafx.scene.layout.StackPane;

public class Cell extends StackPane {

    int row;
    int column;

    public Cell(int row, int column) {
        this.row = row;
    	this.column = column;
        getStyleClass().add("cell");
        setOpacity(0.9);
    }

    public void colorCell() {
        getStyleClass().remove("cell-highlight");
        getStyleClass().add("cell-highlight");
    }

    public void uncolorCell() {
        getStyleClass().remove("cell-highlight");
    }

    public void hoverCell() {
        getStyleClass().remove("cell-hover-highlight");
        getStyleClass().add("cell-hover-highlight");
    }

    public void unhoverCell() {
        getStyleClass().remove("cell-hover-highlight");
    }

    public String toString() {
        return this.column + "/" + this.row;
    }
}
