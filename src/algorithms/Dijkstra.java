package algorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;

import grid.Cell;
import grid.Edge;
import grid.Grid;
import grid.GridMaker;
import grid.Vertex;

public class Dijkstra {
	
	PriorityQueue<Vertex> unvisited;
	
	public ArrayList<Vertex> algorithm(Vertex start, Vertex goal){
		ArrayList<Vertex> path = new ArrayList<>();
		System.out.println(start.toString());
		System.out.println(goal.toString());
		GridMaker grid = new GridMaker();
		Vertex current = start;
//		System.out.println(current.getEdges());
		while(current!=goal) {
			for(Edge edge: current.getEdges()) {
				System.out.println("here");
				Vertex next = (Vertex) edge.getCell();
				double distStart = current.getDistStart() + edge.getCost();
				if(!grid.getGrid().getCell(next.getCoordinate()[0], next.getCoordinate()[1]).isVisited()) {
					grid.getGrid().getCell(next.getCoordinate()[0], next.getCoordinate()[1]).markAdj();
				}
				if(distStart<next.getDistStart()) {
					unvisited.remove(next);
					next.setDistStart(distStart);
					next.setCost(distStart);
					next.setPrevious(current);
					unvisited.add(next);
				}
			}
		}
		while(current.getPrevious()!=null) {
			path.add(current.getPrevious());
			current = current.getPrevious();
			grid.getGrid().getCell(current.getCoordinate()[0], current.getCoordinate()[1]).markPath();
		}
		return path;
	}
}
