package newGrid;

import newGrid.Vertex;

public class Edge {

	Vertex vertex;
	double cost;
	
	public Edge(Vertex destination, double d) {
		this.vertex = destination;
		this.cost = d;
	}
	public Vertex getVertex() {
		return vertex;
	}
    public double getCost() {
    	return cost;
    }
    
    public void setCost(int cost) {
    	this.cost = cost;
    }
    public String toString() {
    	return vertex.toString() + " " + cost;
    }
    
}
