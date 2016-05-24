package hu.unideb.inf.prt.pikkpakk.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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
			int clickRowNum = (int)event.getX()/30;
			int clickColNum = (int)event.getY()/30;
			System.out.printf("%d %d\n", clickColNum, clickRowNum);
			for (Node node : this.getChildren()) {
				if(node instanceof Arrow){
					if(((Arrow) node).isClickable(this) && GridPane.getColumnIndex(node) == clickColNum && GridPane.getRowIndex(node) == clickRowNum){
						((Arrow) node).click(this);
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
	
	public Arrow getArrowByCoords(int col, int row){
		Arrow arrow = (Arrow) this.getChildren()
				.stream()
				.filter(n -> n instanceof Arrow && col == ((Arrow) n).getColNum() && row == ((Arrow) n).getRowNum())
				.reduce((a, b) -> {
		            throw new IllegalStateException("Multiple elements: " + a + ", " + b);
		        })
		        .get();
		return arrow;
	}
	public List<Node> getNodeByCoords(int col, int row)  {
		List<Node> nodes = new ArrayList<Node>();
		ObservableList<Node> childrens = this.getChildren();
		for (int i = 1; i < childrens.size(); i++) {
			if (col == GridPane.getRowIndex(childrens.get(i)) && row == GridPane.getColumnIndex(childrens.get(i))) {
				nodes.add(childrens.get(i));
			}
			
		}

		System.out.println(nodes);
		
		return nodes;
	}

}
