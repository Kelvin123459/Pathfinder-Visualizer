package gui;

import grid.GridMaker;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainGUI extends Application{
	
	double width = 800;
	double height = 675;

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("PathFinder Visualizer");
		VBox vbox = new VBox();
		GridMaker gm = new GridMaker();
		StackPane grid = gm.drawGrid();
		
		VBox vbox2 = new VBox();
		HBox hbox = new HBox();
		Label alg = new Label("Algorithm: ");
		MenuItem Astar = new MenuItem("A* Algorithm");
		MenuItem Djikstra = new MenuItem("DJikstra");
		MenuButton mbutton = new MenuButton("Choose an Algorithm...");
		mbutton.getItems().add(Astar);
		mbutton.getItems().add(Djikstra);
		VBox vbox3 = new VBox();
		Button start = new Button("Start");
		Button stop = new Button("Stop");
		
		vbox3.getChildren().addAll(start, stop);
		hbox.getChildren().addAll(alg, mbutton, vbox3);
		vbox2.getChildren().addAll(hbox);
		vbox.getChildren().addAll(grid, vbox2);
		Scene scene = new Scene(vbox, width, height);
		scene.getStylesheets().add("application.css");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
