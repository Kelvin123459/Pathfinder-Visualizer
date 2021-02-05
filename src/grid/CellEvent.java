package grid;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;

public class CellEvent {

	boolean hover = true;
	Cell start;
	Cell goal;

	EventHandler<MouseEvent> cellColorHandler = event -> {
		Cell cell = (Cell) event.getSource();
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
				cell.colorCell();
				goal = cell;
			}
			else {
				goal.uncolorCell();
				goal = cell;
				cell.colorCell();
			}
		}
	};

	EventHandler<MouseEvent> multiplePickHandler = event -> {
		PickResult pickResult = event.getPickResult();
		Node n = pickResult.getIntersectedNode();
		if(n instanceof Cell) {
			Cell cell = (Cell) n;
			if(event.isPrimaryButtonDown()) {
				cell.colorCell();    
			} 
			else if(event.isSecondaryButtonDown()) {
				cell.colorCell();      
			}
		}
	};

	EventHandler<MouseEvent> dragHandler = event -> {
		Cell cell = (Cell) event.getSource();
		cell.startFullDrag();
	};

	EventHandler<MouseEvent> dragEnterHandler = event -> {
		Cell cell = (Cell) event.getSource();
		if( event.isPrimaryButtonDown()) {
			cell.colorCell();
		} 
		else if( event.isSecondaryButtonDown()) {
			cell.uncolorCell();
		}
	};

	public void colorCell(Node node) {
		if(hover) {
			node.hoverProperty().addListener(new ChangeListener<Boolean>(){
				@Override
				public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
					//                    System.out.println(observable + ": " + newValue);
					if(newValue) {
						((Cell) node).hoverCell();
					} 
					else {
						((Cell) node).unhoverCell();
					}
					//                    for(String s: node.getStyleClass())
						//                        System.out.println(node + ": " + s);
				}
			});
		}
		node.setOnMousePressed(cellColorHandler);
		node.setOnDragDetected(dragHandler);
		node.setOnMouseDragEntered(dragEnterHandler);
	}

	public Cell getStart() {
		return start;
	}

	public Cell getGoal() {
		return goal;
	}
}
