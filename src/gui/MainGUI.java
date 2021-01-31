package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import grid.GridMaker;
import javafx.application.Application;
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

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("PathFinder Visualizer");
		VBox vbox = new VBox();
		GridMaker gm = new GridMaker();
		StackPane grid = gm.drawGrid();
		
		VBox vbox2 = new VBox();
		HBox hbox = new HBox();
		HBox hbox2 = new HBox();
		Label alg = new Label("Algorithm: ");
		Label size = new Label("Grid Size");
		TextField x = new TextField();
		TextField y = new TextField();
		x.setPromptText("X value");
		y.setPromptText("Y value");
		Button setSize = new Button("Set Size");
		MenuItem Astar = new MenuItem("A* Algorithm");
		MenuItem Djikstra = new MenuItem("DJikstra");
		MenuButton mbutton = new MenuButton("Choose an Algorithm...");
		mbutton.getItems().add(Astar);
		mbutton.getItems().add(Djikstra);
		
		//contains the buttons start and stop
		Button start = new Button("Start");
		Button stop = new Button("Reset");
		VBox vbox3 = new VBox();
		vbox3.setSpacing(5);
		vbox3.getChildren().addAll(start, stop);
		vbox3.setPadding(new Insets(0, 0, 0, width*0.7));
		
		
		//contains the label and the menu
		hbox.setSpacing(15);
		hbox.setPadding(new Insets(60, 0, 0, 50));
		hbox.getChildren().addAll(alg, mbutton, vbox3);
		
		hbox2.setSpacing(15);
		hbox2.setPadding(new Insets(0, 0, 30, 50));
		hbox2.getChildren().addAll(size, x, y, setSize);

		vbox2.getChildren().addAll(hbox, hbox2);
		vbox.setSpacing(30);
		vbox.getChildren().addAll(grid, vbox2);
		
		Scene scene = new Scene(vbox);
		scene.getStylesheets().add("application.css");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);;
		primaryStage.setMaximized(true);
		primaryStage.show();
	}

}
