package grid;

import java.util.ArrayList;

public class Vertex {
	
	double distStart;
	double cost; 
	int[] position;
	Vertex previous;
	ArrayList<Edge> edges;
	
	public Vertex(int x, int y) {
		distStart = Double.POSITIVE_INFINITY;
		edges = new ArrayList<Edge>();
		position = new int[] {x,y};
	}
	
	public void addEdge(Edge edge) {
		edges.add(edge);
	}

	public double getDistStart() {
		return distStart;
	}

	public void setDistStart(double distStart) {
		this.distStart = distStart;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Vertex getPrevious() {
		return previous;
	}

	public void setPrevious(Vertex previous) {
		this.previous = previous;
	}

	public ArrayList<Edge> getEdges() {
		return edges;
	}

	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}
	
	public int[] getCoordinate() {
		return position;
	}
	
	public ArrayList<Edge> adjacentCells(int rows, int columns, Edge cell){
    	ArrayList<Edge> adj = new ArrayList<Edge>();
    	Edge edge;
    	int x = cell.getCell().getCoordinate()[0];
    	int y = cell.getCell().getCoordinate()[1];
    	if(x!=0) {
    		edge = new Edge(new Vertex(x-1,y), cell.getCost()+1);
    		adj.add(edge);
    		if(y!=0) {
    			edge = new Edge(new Vertex(x-1,y-1), cell.getCost()+1);
        		adj.add(edge);
        	}
    		if(y+1<rows) {
    			edge = new Edge(new Vertex(x-1,y+1), cell.getCost()+1);
        		adj.add(edge);
    		}
    	}
    	if(y!=0) {
    		edge = new Edge(new Vertex(x,y-1), cell.getCost()+1);
    		adj.add(edge);
    		if(x+1<columns) {
    			edge = new Edge(new Vertex(x+1,y-1), cell.getCost()+1);
        		adj.add(edge);
        	}
    	}
    	if(x+1<columns) {
    		edge = new Edge(new Vertex(x+1,y), cell.getCost()+1);
    		adj.add(edge);
    		if(y+1<rows) {
    			edge = new Edge(new Vertex(x+1,y+1), cell.getCost()+1);
        		adj.add(edge);
    		}
    	}
    	if(y+1<rows) {
    		edge = new Edge(new Vertex(x,y+1), cell.getCost()+1);
    		adj.add(edge);
    	}
    	return adj;
    }
}
