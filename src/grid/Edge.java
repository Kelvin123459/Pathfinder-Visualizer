package grid;

public class Edge {
	Vertex vertex;
	double cost;
	
	public Edge(Vertex destination, double d) {
		this.vertex = destination;
		this.cost = d;
	}
	public Vertex getCell() {
		return vertex;
	}
    public double getCost() {
    	return cost;
    }
    
    public void setCost(int cost) {
    	this.cost = cost;
    }
}
