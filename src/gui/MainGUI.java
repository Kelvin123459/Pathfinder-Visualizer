package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import algorithms.Dijkstra;
import grid.Cell;
import grid.CellEvent;
import grid.GridMaker;
import grid.Vertex;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainGUI extends Application{
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	double height = screenSize.getHeight();
	int xInt = 20;
	int yInt = 20;

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("PathFinder Visualizer");
		GridMaker gm = new GridMaker();
		
		
		//setup containers
		VBox root = new VBox(); //contains the grid and the first leftVbox
		StackPane grid = gm.drawGrid(xInt, yInt);
		VBox leftVbox = new VBox(); //contains both hBoxes
		HBox buttonBox = new HBox(); //contains all buttons
		HBox topHBox = new HBox(); //contains the algorithms
		HBox botHBox = new HBox(); //contains the grid sizes
		VBox rightVbox = new VBox();   //contains the start and reset buttons
		Scene scene = new Scene(root);
		
		//setup components
		Label alg = new Label("Algorithm: ");
		Label size = new Label("Grid Size:   ");
		TextField x = new TextField();
		TextField y = new TextField();
		x.setPromptText("X value");
		y.setPromptText("Y value");
		Button setSize = new Button("Set Size");
		Button start = new Button("Start");
		Button reset = new Button("Reset");
		MenuItem Astar = new MenuItem("A* Algorithm");
		MenuItem Djikstra = new MenuItem("DJikstra");
		MenuButton mbutton = new MenuButton("Choose an Algorithm...");
		mbutton.getItems().add(Astar);
		mbutton.getItems().add(Djikstra);
		
		setSize.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(x.getText()!=null&&y.getText()!=null) {
					xInt = Integer.parseInt(x.getText());
					yInt = Integer.parseInt(y.getText());
					VBox newRoot = new VBox();
					StackPane newGrid = gm.drawGrid(xInt,yInt);
					newRoot.getChildren().addAll(newGrid, buttonBox);	
					primaryStage.getScene().setRoot(newRoot);
				}
			}
		});
		
		start.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Dijkstra algo = new Dijkstra();
				CellEvent ce = gm.getCellEvent();
				Cell starting = ce.getStart();
				Cell ending = ce.getGoal();
				algo.algorithm(starting.getVertex(), ending.getVertex(), gm.getGrid());
			}
			
		});
		
		reset.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				VBox newRoot = new VBox();
				StackPane newGrid = gm.drawGrid(xInt,yInt);
				newRoot.getChildren().addAll(newGrid, buttonBox);	
				primaryStage.getScene().setRoot(newRoot);
			}
		});
		
		//edit containers
		//root
		root.setSpacing(30);
		//buttonBox
		buttonBox.setSpacing(width*0.45);
		//rightVBox
		rightVbox.setSpacing(10);
		rightVbox.setPadding(new Insets(0, 0, 0, 30));
		//topHBox
		topHBox.setSpacing(15);
		topHBox.setPadding(new Insets(0, 0, 0, 50));
		//botHbox
		botHBox.setSpacing(15);
		botHBox.setPadding(new Insets(10, 0, 0, 50));
		
		//add components to containers
		root.getChildren().addAll(grid, buttonBox);	
		buttonBox.getChildren().addAll(leftVbox, rightVbox);
		leftVbox.getChildren().addAll(topHBox, botHBox);
			topHBox.getChildren().addAll(alg, mbutton);
			botHBox.getChildren().addAll(size, x, y, setSize);
		rightVbox.getChildren().addAll(start, reset);
		
		scene.getStylesheets().add("application.css");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);;
		primaryStage.setMaximized(true);
		primaryStage.show();
		
	}

}
