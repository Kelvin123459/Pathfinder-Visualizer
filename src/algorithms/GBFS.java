package algorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;

import grid.Edge;
import grid.Grid;
import grid.Vertex;

public class GBFS {
	PriorityQueue<Vertex> unvisited;
	ArrayList<Vertex> visited;
	
	public GBFS(){
		unvisited = new PriorityQueue<Vertex>();
		visited = new ArrayList<Vertex>();
	}
	
	public ArrayList<Vertex> algorithm(Vertex start, Vertex goal, Grid grid){
		ArrayList<Vertex> path = new ArrayList<>();
		start.setDistStart(0);
		double distance = calculateDist(start, goal);
		start.setCost((int)distance);
		unvisited.add(start);
		Vertex min = start;
		while(!unvisited.isEmpty()) {
			Vertex current = unvisited.poll();
			current.markVisited();
			visited.add(current);
			if(current == goal) {
				break;
			}
			for(Edge edge: current.getEdges()) {
				Vertex next = grid.getCell(edge.getVertex().getCoordinate()[0], edge.getVertex().getCoordinate()[1]);
				if(visited.contains(next)) {
					continue;
				}
				double distGoal = calculateDist(next, goal);
				if(!next.isVisited()) {
					next.markAdj();
				}
				if(distGoal<min.getCost()) {
					next.setCost(distGoal);
					min = next;
				}
			}	
			min.setPrevious(current);
			unvisited.add(min);
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
	
	double calculateDist(Vertex start, Vertex goal){
		double x1 = start.getCoordinate()[0];
		double y1 = start.getCoordinate()[1];
		double x2 = goal.getCoordinate()[0];
		double y2 = goal.getCoordinate()[1];
		double distance = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
		return distance;
	}
}
