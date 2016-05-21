package hu.unideb.inf.prt.pikkpakk.controllers;



import hu.unideb.inf.prt.pikkpakk.Main;
import hu.unideb.inf.prt.pikkpakk.model.Board;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ViewController {
	
	Main main;
	
	@FXML
	private Board board;
	  
	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
		addCirclesToGrid();
	}
	
	public void addCirclesToGrid(){
		
		board.fillToDefault();
			
			
			//MouseEvent me;
			
		
		
	}

}
