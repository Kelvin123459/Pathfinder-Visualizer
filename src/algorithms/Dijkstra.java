package algorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;

import grid.CellEvent;
import grid.Edge;
import grid.Grid;
import grid.GridMaker;
import grid.Vertex;

public class Dijkstra {
	
	PriorityQueue<Vertex> unvisited;
	
	public Dijkstra() {
		unvisited = new PriorityQueue<Vertex>();
	}
	
	public ArrayList<Vertex> algorithm(Vertex start, Vertex goal, Grid grid){
		ArrayList<Vertex> path = new ArrayList<>();
		start.setDistStart(0);
		start.setCost(0);
		unvisited.add(start);
		while(!unvisited.isEmpty()) {
			Vertex current = unvisited.poll();
			current.markVisited();
			if(current == goal) {
				break;
			}
			for(Edge edge: current.getEdges()) {
				Vertex next = grid.getCell(edge.getVertex().getCoordinate()[0], edge.getVertex().getCoordinate()[1]);
				double distStart = current.getDistStart() + edge.getCost();
				if(!next.isVisited()) {
					next.markAdj();
				}
				if(distStart<next.getDistStart()) {
					unvisited.remove(next);
					next.setDistStart(distStart);
					next.setCost((int)distStart);
					next.setPrevious(current);
					unvisited.add(next);
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
