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
	
	public ArrayList<Vertex> algorithm(Cell start, Cell goal){
		ArrayList<Vertex> path = new ArrayList<>();
		Vertex startV = new Vertex(start.getCoordinate()[0], start.getCoordinate()[1]);
		Vertex goalV = new Vertex(goal.getCoordinate()[0], goal.getCoordinate()[1]);
		GridMaker grid = new GridMaker();
		Vertex current = startV;
		while(current!=goalV) {
			for(Edge edge: current.getEdges()) {
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
