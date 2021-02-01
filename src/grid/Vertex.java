package grid;

import java.util.ArrayList;

public class Vertex {
	
	double distStart;
	double cost; 
	int[] position;
	Vertex previous;
	ArrayList<Edge> edges;
	Cell cell;
	GridMaker grid = new GridMaker();
	
	public Vertex(int x, int y) {
		distStart = Double.POSITIVE_INFINITY;
		position = new int[] {x,y};
		cell = new Cell(x,y);
		edges = new ArrayList<Edge>();
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
		return edges = grid.getGrid().adjacentCells(this);
	}

	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}
	
	public int[] getCoordinate() {
		return position;
	}
	public String toString() {
		return position[0] + "/" + position[1];
	}
	public Cell getCell() {
		return cell;
	}
}
