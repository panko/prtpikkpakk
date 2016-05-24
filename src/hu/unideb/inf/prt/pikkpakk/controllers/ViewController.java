package hu.unideb.inf.prt.pikkpakk.controllers;

import hu.unideb.inf.prt.pikkpakk.model.Board;
import hu.unideb.inf.prt.pikkpakk.model.Match;
import javafx.fxml.FXML;

public class ViewController {
	
	
	
	@FXML
	private Board board;
	  

	private void addCirclesToGrid(){
		
		board.fillToDefault();
			
	}
	
	public void startGame(){
		
		addCirclesToGrid();
		board.addMouseEvent();
		Match match = new Match();
			
	}
}
