package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import grid.Edge;
import grid.Grid;
import grid.Vertex;

public class DFS {
	Queue<Vertex> unvisited;
	ArrayList<Vertex> visited;
	ArrayList<Vertex> path;
	
	public DFS(){
		unvisited = new LinkedList<Vertex>();
		visited = new ArrayList<Vertex>();
		path = new ArrayList<>();
	}
	
	public ArrayList<Vertex> algorithm(Vertex start, Vertex goal, Grid grid){
		Vertex current = start;
		visited.add(current);
		current.markVisited();
		for(Edge edge: current.getEdges()) {
			Vertex next = grid.getCell(edge.getVertex().getCoordinate()[0], edge.getVertex().getCoordinate()[1]);
			if(current == goal) {
				break;
			}
			if(!next.isVisited()) {
				next.markAdj();
				next.setPrevious(current);	
				algorithm(next, goal, grid);
			}
		}
		current = goal;
		path.add(current);
		grid.getCell(current.getCoordinate()[0], current.getCoordinate()[1]).markGoal();
		while(current.getPrevious()!=null) {
			path.add(current.getPrevious());
			current = current.getPrevious();
			grid.getCell(current.getCoordinate()[0], current.getCoordinate()[1]).markPath();
			if(current.getPrevious()==null) {
				grid.getCell(current.getCoordinate()[0], current.getCoordinate()[1]).markStart();
			}
		}
		return path;
	}	
}
