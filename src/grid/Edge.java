package grid;

public class Edge {
	Vertex vertex;
	int cost;
	
	public Edge(Vertex destination, int cost) {
		this.vertex = destination;
		this.cost = cost;
	}
	public Vertex getCell() {
		return vertex;
	}
    public int getCost() {
    	return cost;
    }
    
    public void setCost(int cost) {
    	this.cost = cost;
    }
}
