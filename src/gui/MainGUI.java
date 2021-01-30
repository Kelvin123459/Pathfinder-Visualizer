package gui;

import grid.GridMaker;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainGUI extends Application{
	
	double width = 800;
	double height = 600;

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("PathFinder Visualizer");
		VBox vbox = new VBox();
		GridMaker gm = new GridMaker();
		StackPane grid = gm.drawGrid();
		
		VBox vbox2 = new VBox();
		HBox hbox = new HBox();
		
		hbox.getChildren().addAll();
		vbox2.getChildren().addAll(hbox);
		vbox.getChildren().addAll(grid, vbox2);
		Scene scene = new Scene(vbox, width, height);
		scene.getStylesheets().add("application.css");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
