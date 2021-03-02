package grid;
import javafx.scene.layout.Pane;

public class Grid extends Pane{
	double rows;
    double columns;

    double width;
    double height;
    int rH;
    boolean searching;

    Vertex[][] cells;

    public Grid(int rows, int columns, double width, double height) {
        this.columns = columns;
        this.rows = rows;
        this.width = width;
        this.height = height;
        this.rH = (int)height/rows;
        searching = false;
        cells = new Vertex[rows][columns];
    }
    
    public void addCell(Vertex vertex, int row, int column) {
        int xPoint = vertex.getCoordinate()[0];
    	int yPoint = vertex.getCoordinate()[1];
       	
    	if(xPoint+1<rows) {
    		vertex.addEdge(new Edge(new Vertex(xPoint+1,yPoint), rH));
    	}
    	if(yPoint+1<columns) {
    		vertex.addEdge(new Edge(new Vertex(xPoint,yPoint+1), rH));
    	}
    	if(xPoint-1>=0) {
    		vertex.addEdge(new Edge(new Vertex(xPoint-1,yPoint), rH));
    	}
    	if(yPoint-1>=0) {
    		vertex.addEdge(new Edge(new Vertex(xPoint,yPoint-1), rH));
    	}
    	if(xPoint+1<rows&&yPoint+1<columns) {
    		vertex.addEdge(new Edge(new Vertex(xPoint+1,yPoint+1), rH*1.4));
    	}
    	if(xPoint-1>=0&&yPoint-1>=0) {
    		vertex.addEdge(new Edge(new Vertex(xPoint-1,yPoint-1), rH*1.4));
    	}
    	if(xPoint+1<rows&&yPoint-1>=0) {
    		vertex.addEdge(new Edge(new Vertex(xPoint+1,yPoint-1), rH*1.4));
    	}
    	if(xPoint-1>=0&&yPoint+1<columns) {
    		vertex.addEdge(new Edge(new Vertex(xPoint-1,yPoint+1), rH*1.4));
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
