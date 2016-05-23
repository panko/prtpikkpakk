package hu.unideb.inf.prt.pikkpakk.model;

import java.util.ArrayList;

import javafx.collections.ObservableList;
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
			int clickColNum = (int)event.getX()/33;
			int clickRowNum = (int)event.getY()/33;
			for (Node node : this.getChildren()) {
				if(node instanceof Polygon){
					if(GridPane.getColumnIndex(node) == clickColNum && GridPane.getRowIndex(node) == clickRowNum){
						if(clickRowNum == 0 || clickRowNum == 10){
							pushNodesHorizontically(clickColNum, clickRowNum);
						}
						else if (clickColNum == 0 || clickColNum == 10) {
							pushNodesVertically(clickColNum, clickRowNum);
						}
					}
					
				}
				
				
			}
		});
	}
	
	public void fillToDefault(){
		this.add(new Circle(15, Color.BLACK), 5, 5);
		
		this.add(new Circle(15, Color.BLUE), 2, 2);
		this.add(new Circle(15, Color.BLUE), 2, 3);
		this.add(new Circle(15, Color.BLUE), 2, 4);
		this.add(new Circle(15, Color.BLUE), 2, 5);
		this.add(new Circle(15, Color.BLUE), 2, 6);
		this.add(new Circle(15, Color.BLUE), 2, 7);
		this.add(new Circle(15, Color.BLUE), 3, 7);
		this.add(new Circle(15, Color.BLUE), 4, 7);
		this.add(new Circle(15, Color.BLUE), 5, 7);
		this.add(new Circle(15, Color.BLUE), 6, 7);
		this.add(new Circle(15, Color.BLUE), 6, 6);
		this.add(new Circle(15, Color.BLUE), 6, 5);
		//innentől alsó bal kék
		this.add(new Circle(15, Color.BLUE), 4, 5);
		this.add(new Circle(15, Color.BLUE), 4, 4);
		this.add(new Circle(15, Color.BLUE), 4, 3);
		this.add(new Circle(15, Color.BLUE), 5, 3);
		this.add(new Circle(15, Color.BLUE), 6, 3);
		this.add(new Circle(15, Color.BLUE), 7, 3);
		this.add(new Circle(15, Color.BLUE), 8, 3);
		this.add(new Circle(15, Color.BLUE), 8, 4);
		this.add(new Circle(15, Color.BLUE), 8, 5);
		this.add(new Circle(16, Color.BLUE), 8, 6);
		this.add(new Circle(15, Color.BLUE), 8, 7);
		this.add(new Circle(15, Color.BLUE), 8, 8);
		
		this.add(new Circle(15, Color.RED), 3, 2);
		this.add(new Circle(15, Color.RED), 4, 2);
		this.add(new Circle(15, Color.RED), 5, 2);
		this.add(new Circle(15, Color.RED), 6, 2);
		this.add(new Circle(15, Color.RED), 7, 2);
		this.add(new Circle(15, Color.RED), 8, 2);
		this.add(new Circle(15, Color.RED), 3, 3);
		this.add(new Circle(15, Color.RED), 3, 4);
		this.add(new Circle(15, Color.RED), 3, 5);
		this.add(new Circle(15, Color.RED), 3, 6);
		this.add(new Circle(15, Color.RED), 4, 6);
		this.add(new Circle(15, Color.RED), 5, 6);
		
		this.add(new Circle(15, Color.RED), 5, 4);
		this.add(new Circle(15, Color.RED), 6, 4);
		this.add(new Circle(15, Color.RED), 7, 4);
		this.add(new Circle(15, Color.RED), 7, 5);
		this.add(new Circle(15, Color.RED), 7, 6);
		this.add(new Circle(15, Color.RED), 7, 7);
		this.add(new Circle(15, Color.RED), 7, 8);
		this.add(new Circle(15, Color.RED), 6, 8);
		this.add(new Circle(15, Color.RED), 5, 8);
		this.add(new Circle(15, Color.RED), 4, 8);
		this.add(new Circle(15, Color.RED), 3, 8);
		this.add(new Circle(15, Color.RED), 2, 8);

		fillWithArrows();
	}
	
	private void pushNodesVertically(int col, int row){
	     ArrayList<Node> childrenInRow = new ArrayList<Node>();
	     ObservableList<Node> children = this.getChildren();
	     for (int i = 0; i < children.size(); ++i)
	          if (GridPane.getRowIndex(children.get(i)) == index)
	          {
	               childrenInRow.add(children.get(i));
	               children.remove(i);
	          }
	     gridPane.addRow(index, toReplace);
	     //do something with childrenInRow if needed.
	}
	
	private void pushNodesHorizontically(int col, int row){
	     ArrayList<Node> childrenInRow = new ArrayList<Node>();
	     ObservableList<Node> children = this.getChildren();
	     for (int i = 0; i < children.size(); ++i)
	          if (GridPane.getRowIndex(children.get(i)) == index)
	          {
	               childrenInRow.add(children.get(i));
	               children.remove(i);
	          }
	     gridPane.addRow(index, toReplace);
	     //do something with childrenInRow if needed.
	}

	private void fillWithArrows() {
		final int gridPaneSize = 8+1; 
		
		for (int i = 1+1; i < gridPaneSize; i++) {
			this.add(new Arrow(new Double[]{
                    0.0, 10.0,
                    -10.0, -10.0,
                    10.0, -10.0}, 90), gridPaneSize+1, i);
		}
		for (int i = 1+1; i < gridPaneSize; i++) {
			this.add(new Arrow(new Double[]{
                    0.0, 10.0,
                    -10.0, -10.0,
                    10.0, -10.0}, -90), 0, i);
		}
		for (int i = 1+1; i < gridPaneSize; i++) {
			this.add(new Arrow(new Double[]{
                    0.0, 10.0,
                    -10.0, -10.0,
                    10.0, -10.0}, 0), i, 0);
		}
		for (int i = 1+1; i < gridPaneSize; i++) {
			this.add(new Arrow(new Double[]{
                    0.0, 10.0,
                    -10.0, -10.0,
                    10.0, -10.0}, 180), i, gridPaneSize+1);
		}
		//eztendeld a poligonokat egy arrowal és tedd lekérdezhetővé az idjét
		
	}
	
	

}
