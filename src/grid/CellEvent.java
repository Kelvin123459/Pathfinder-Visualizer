package grid;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;

public class CellEvent {

	boolean hover = true;
	Vertex start;
	Vertex goal;

	EventHandler<MouseEvent> cellColorHandler = event -> {
		Vertex cell = (Vertex) event.getSource();
		if(event.isPrimaryButtonDown()) {
			if(start==null) {
				cell.colorCell();
				start = cell;
			}
			else {
				start.uncolorCell();
				start = cell;
				cell.colorCell();
			}
		} 
		else if(event.isSecondaryButtonDown()) {
			if(goal==null) {
				cell.markGoal();
				goal = cell;
			}
			else {
				goal.unmarkGoal();
				goal = cell;
				cell.markGoal();
			}
		}
	};

//	EventHandler<MouseEvent> multiplePickHandler = event -> {
//		PickResult pickResult = event.getPickResult();
//		Node n = pickResult.getIntersectedNode();
//		if(n instanceof Vertex) {
//			Vertex cell = (Vertex) n;
//			if(event.isPrimaryButtonDown()) {
//				cell.colorCell();    
//			} 
//			else if(event.isSecondaryButtonDown()) {
//				cell.colorCell();      
//			}
//		}
//	};

//	EventHandler<MouseEvent> dragHandler = event -> {
//		Vertex cell = (Vertex) event.getSource();
//		cell.startFullDrag();
//	};
//
//	EventHandler<MouseEvent> dragEnterHandler = event -> {
//		Vertex cell = (Vertex) event.getSource();
//		if( event.isPrimaryButtonDown()) {
//			cell.colorCell();
//		} 
//		else if( event.isSecondaryButtonDown()) {
//			cell.uncolorCell();
//		}
//	};

	public void colorCell(Node node) {
		if(hover) {
			node.hoverProperty().addListener(new ChangeListener<Boolean>(){
				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					//                    System.out.println(observable + ": " + newValue);
					if(newValue) {
						((Vertex) node).hoverCell();
					} 
					else {
						((Vertex) node).unhoverCell();
					}
					//                    for(String s: node.getStyleClass())
						//                        System.out.println(node + ": " + s);
				}
			});
		}
		node.setOnMousePressed(cellColorHandler);
//		node.setOnDragDetected(dragHandler);
//		node.setOnMouseDragEntered(dragEnterHandler);
	}

	public Vertex getStart() {
		return start;
	}

	public Vertex getGoal() {
		return goal;
	}
}
