package newGrid;
import javafx.scene.layout.Pane;

public class Grid extends Pane{
	int rows;
    int columns;

    double width;
    double height;
    double rH;
    double cW;
    boolean searching;

    Vertex[][] cells;

    public Grid(int rows, int columns, double width, double height) {
        this.columns = columns;
        this.rows = rows;
        this.width = width;
        this.height = height;
        this.rH = height/rows;
        this.cW = width/columns;
        searching = false;
        cells = new Vertex[rows][columns];
    }
    
    public void addCell(Vertex vertex, int row, int column) {
        Edge edge;
        int xPoint = vertex.getCoordinate()[0];
    	int yPoint = vertex.getCoordinate()[1];
    	if(xPoint-1>=0) {
    		edge = new Edge(new Vertex(xPoint-1,yPoint), cW);
    		vertex.addEdge(edge);
    		if(yPoint-1>=0) {
    			edge = new Edge(new Vertex(xPoint-1,yPoint-1), rH*1.4);
    			vertex.addEdge(edge);
        	}
    		if(yPoint+1<rows) {
    			edge = new Edge(new Vertex(xPoint-1,yPoint+1), rH*1.4);
    			vertex.addEdge(edge);
    		}
    	}
    	if(yPoint-1>=0) {
    		edge = new Edge(new Vertex(xPoint,yPoint-1), rH);
    		vertex.addEdge(edge);
    		if(xPoint+1<columns) {
    			edge = new Edge(new Vertex(xPoint+1,yPoint-1), rH*1.4);
    			vertex.addEdge(edge);
        	}
    	}
    	if(xPoint+1<columns) {
    		edge = new Edge(new Vertex(xPoint+1,yPoint), rH);
    		vertex.addEdge(edge);
    		
    		if(yPoint+1<rows) {
    			edge = new Edge(new Vertex(xPoint+1,yPoint+1), rH*1.4);
    			vertex.addEdge(edge);
    		}
    	}
    	if(yPoint+1<rows) {
    		edge = new Edge(new Vertex(xPoint,yPoint+1), cW);
    		vertex.addEdge(edge);
    	}
    	
    	cells[row][column] = vertex;
        double prefWidth = width / columns;
        double prefHeight = height / rows;
        double x = prefWidth * column;
        double y = prefHeight * row;

        vertex.setLayoutX(x);
        vertex.setLayoutY(y);
        vertex.setPrefWidth(prefWidth);
        vertex.setPrefHeight(prefHeight);
        
        
        getChildren().add(vertex);
    }
    
    public Vertex getCell(int row, int column) {
        return cells[row][column];
    }
    
}
