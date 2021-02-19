package newGrid;

import java.util.ArrayList;

import javafx.scene.layout.StackPane;

public class Vertex extends StackPane implements Comparable<Vertex>{
	
	double distStart;
	double cost; 
	int[] position;
	Vertex previous;
	boolean colored = false;
    boolean visited = false;
	ArrayList<Edge> edges;
	
	public Vertex(int row, int column) {
		distStart = Double.POSITIVE_INFINITY;
		position = new int[] {row,column};
		edges = new ArrayList<Edge>();
		getStyleClass().add("cell");
        setOpacity(0.9);
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
	public String toString() {
		return position[0] + "/" + position[1];
	}
	public int compareTo(Vertex other){
		return Double.compare(cost, other.cost);
	}
	
	public boolean isColored() {
    	return colored;
    }
    public boolean isVisited() {
    	return visited;
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

}
