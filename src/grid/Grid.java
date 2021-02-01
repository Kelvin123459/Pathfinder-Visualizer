package grid;

import java.util.ArrayList;

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
    
    public Cell getCell(int row, int column) {
        return cells[row][column];
    }
    
	public ArrayList<Edge> adjacentCells(Vertex cell){
    	ArrayList<Edge> edges = new ArrayList<Edge>();
		Edge edge;
    	int x = cell.getCoordinate()[0];
    	int y = cell.getCoordinate()[1];
    	if(x!=0) {
    		edge = new Edge(new Vertex(x-1,y), cell.getCost()+1);
    		cell.addEdge(edge);
    		if(y!=0) {
    			edge = new Edge(new Vertex(x-1,y-1), cell.getCost()+1);
    			cell.addEdge(edge);
        	}
    		if(y+1<rows) {
    			edge = new Edge(new Vertex(x-1,y+1), cell.getCost()+1);
    			cell.addEdge(edge);
    		}
    	}
    	if(y!=0) {
    		edge = new Edge(new Vertex(x,y-1), cell.getCost()+1);
    		cell.addEdge(edge);
    		if(x+1<columns) {
    			edge = new Edge(new Vertex(x+1,y-1), cell.getCost()+1);
    			cell.addEdge(edge);
        	}
    	}
    	if(x+1<columns) {
    		edge = new Edge(new Vertex(x+1,y), cell.getCost()+1);
    		cell.addEdge(edge);
    		
    		if(y+1<rows) {
    			edge = new Edge(new Vertex(x+1,y+1), cell.getCost()+1);
    			cell.addEdge(edge);
    		}
    	}
    	if(y+1<rows) {
    		edge = new Edge(new Vertex(x,y+1), cell.getCost()+1);
    		cell.addEdge(edge);
    	}
    	return edges;
    }
	
}