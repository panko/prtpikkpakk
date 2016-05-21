package hu.unideb.inf.prt.pikkpakk.model;

import java.util.ArrayList;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

public class Board extends GridPane {
	
	
	
	
	public Board() {
		super();
		// TODO Auto-generated constructor stub
		this.setGridLinesVisible(true);
		
		this.addEventFilter(MouseEvent.MOUSE_CLICKED,(event) -> {
			for (Node node : this.getChildren()) {
				if(node instanceof Polygon){
					System.out.println(node);
				}
				
				
			}
		});
	}
	
	public void fillToDefault(){
		this.add(new Circle(16, Color.BLACK), 4, 4);
		
		this.add(new Circle(16, Color.BLUE), 1, 1);
		this.add(new Circle(16, Color.BLUE), 1, 2);
		this.add(new Circle(16, Color.BLUE), 1, 3);
		this.add(new Circle(16, Color.BLUE), 1, 4);
		this.add(new Circle(16, Color.BLUE), 1, 5);
		this.add(new Circle(16, Color.BLUE), 1, 6);
		this.add(new Circle(16, Color.BLUE), 2, 6);
		this.add(new Circle(16, Color.BLUE), 3, 6);
		this.add(new Circle(16, Color.BLUE), 4, 6);
		this.add(new Circle(16, Color.BLUE), 5, 6);
		this.add(new Circle(16, Color.BLUE), 5, 5);
		this.add(new Circle(16, Color.BLUE), 5, 4);
		
		this.add(new Circle(16, Color.RED), 3, 4);
		this.add(new Circle(16, Color.RED), 3, 3);
		this.add(new Circle(16, Color.RED), 3, 2);
		this.add(new Circle(16, Color.RED), 4, 2);
		this.add(new Circle(16, Color.RED), 5, 2);
		this.add(new Circle(16, Color.RED), 6, 2);
		this.add(new Circle(16, Color.RED), 7, 2);
		this.add(new Circle(16, Color.RED), 7, 3);
		
		
		fillWithArrows();
	}

	private void fillWithArrows() {
		final int gridPaneSize = 8; 
		
		for (int i = 1; i < gridPaneSize; i++) {
			Polygon arrow = new Polygon();
	        arrow.getPoints().addAll(new Double[]{
	                    0.0, 10.0,
	                    -10.0, -10.0,
	                    10.0, -10.0});
	        arrow.setRotate(90);
			this.add(arrow, 8, i);
		}
		for (int i = 1; i < gridPaneSize; i++) {
			Polygon arrow = new Polygon();
	        arrow.getPoints().addAll(new Double[]{
                    0.0, 10.0,
                    -10.0, -10.0,
                    10.0, -10.0});
	        arrow.setRotate(-90);
			this.add(arrow, 0, i);
		}
		for (int i = 1; i < gridPaneSize; i++) {
			Polygon arrow = new Polygon();
	        arrow.getPoints().addAll(new Double[]{
                    0.0, 10.0,
                    -10.0, -10.0,
                    10.0, -10.0});
	        //arrow.setRotate();
			this.add(arrow, i, 0);
		}
		for (int i = 1; i < gridPaneSize; i++) {
			Polygon arrow = new Polygon();
	        arrow.getPoints().addAll(new Double[]{
                    0.0, 10.0,
                    -10.0, -10.0,
                    10.0, -10.0});
	        arrow.setRotate(180);
			this.add(arrow, i, 8);
		}
		
	}
	

}
