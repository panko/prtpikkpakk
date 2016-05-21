package hu.unideb.inf.prt.pikkpakk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hu.unideb.inf.prt.pikkpakk.controllers.ViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;

public class Main  extends Application{
	
	private Stage primaryStage;
	private BorderPane rootPane;
	
	private List<Circle> circleList = new ArrayList<Circle>();
	

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Pikk-Pakk");
		
		createRootPane();
		createPikkPakkView();
	}

	public static void main(String[] args) {
		launch(args);

	}
	
	private void createRootPane(){
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/RootPaneView.fxml"));
		try {
			rootPane = (BorderPane)loader.load();
			
			Scene scene = new Scene(rootPane);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void createPikkPakkView(){
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/PikkPakkView.fxml"));
		try {
			HBox pikkPakkView = (HBox)loader.load();
			rootPane.setCenter(pikkPakkView);
			
			ViewController controller = loader.getController();
			controller.setMain(this);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public List<Circle> getCircleList() {
		return circleList;
	}

	public void setCircleList(List<Circle> circleList) {
		this.circleList = circleList;
	}

}
