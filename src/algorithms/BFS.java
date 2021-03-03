package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import grid.Edge;
import grid.Grid;
import grid.Vertex;

public class BFS {
	Queue<Vertex> unvisited;
	ArrayList<Vertex> visited;
	
	public BFS(){
		unvisited = new LinkedList<Vertex>();
		visited = new ArrayList<Vertex>();
	}
	
	public ArrayList<Vertex> algorithm(Vertex start, Vertex goal, Grid grid){
		ArrayList<Vertex> path = new ArrayList<>();
		start.setDistStart(0);
		start.setCost(0);
		unvisited.add(start);
		while(!unvisited.isEmpty()) {
			Vertex current = unvisited.remove();
			current.markVisited();
			visited.add(current);
			if(current == goal) {
				break;
			}
			for(Edge edge: current.getEdges()) {
				Vertex next = grid.getCell(edge.getVertex().getCoordinate()[0], edge.getVertex().getCoordinate()[1]);
				if(!next.isVisited()) {
					next.markAdj();
					if(!unvisited.contains(next)) {
						unvisited.add(next);
						next.setPrevious(current);
						double distStart = current.getDistStart() + edge.getCost();
						next.setDistStart(distStart);
						next.setCost((int)distStart);
					}
				}
			}
		}
		Vertex current = goal;
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
		System.out.println(path.toString());
		return path;
	}
}
