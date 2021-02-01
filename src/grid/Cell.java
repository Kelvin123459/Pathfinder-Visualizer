package grid;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javafx.scene.layout.StackPane;

public class Cell extends StackPane {

    int row;
    int column;
    int[] coordinates = new int[] {row,column};
    boolean colored = false;
    boolean visited = false;
    Vertex vertex;

    public Cell(int row, int column) {
        this.row = row;
    	this.column = column;
        getStyleClass().add("cell");
        setOpacity(0.9);
    }
    
    public void addVertex(Vertex vertex){
    	this.vertex = vertex;
    }
    
    public Vertex getVertex() {
    	return vertex;
    }

    public void colorCell() {
        getStyleClass().remove("cell-highlight");
        getStyleClass().add("cell-highlight");
        colored = true;
    }

    public void uncolorCell() {
        getStyleClass().remove("cell-highlight");
        colored = false;
    }

    public void hoverCell() {
        getStyleClass().remove("cell-hover-highlight");
        getStyleClass().add("cell-hover-highlight");
    }

    public void unhoverCell() {
        getStyleClass().remove("cell-hover-highlight");
    }
    
    public void markVisited() {
    	getStyleClass().clear();
    	getStyleClass().add("cell");
    	getStyleClass().add("cell-visited");
    	visited = true;
    }
    
    public void markAdj() {
    	getStyleClass().add("cell-adj");
    }
    
    public void markPath() {
    	getStyleClass().clear();
    	getStyleClass().add("cell");
    	getStyleClass().add("cell-path");
    }
    
    public void markGoal() {
    	getStyleClass().add("cell-goal");
    }

    public String toString() {
        return this.column + "/" + this.row;
    }
    
    public int[] getCoordinate() {
    	return coordinates;
    }
    
    public boolean isColored() {
    	return colored;
    }
    public boolean isVisited() {
    	return visited;
    }
}
