package hu.unideb.inf.prt.pikkpakk.model;
import java.util.List;
import java.util.stream.Collectors;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

public class Arrow extends Polygon{
	


	public Arrow() {
		super();

		// TODO Auto-generated constructor stub
	}
	
	public Arrow(Double[] points, int rotate) {
        this.getPoints().addAll(points);
        this.setRotate(rotate);
	}
	
	public int getColNum(){
		return (int)this.getLayoutX() / 30;
	}
	public int getRowNum(){
		return (int)this.getLayoutY() / 30;
	}
	
	public void click(Board board){
		ObservableList<Node> childrens = board.getChildren();
		for (Node node : childrens) {
			if (node instanceof Circle && (GridPane.getColumnIndex(node) == this.getRowNum())) {//felsoalso
				System.out.printf("col:%d row:%d\n",GridPane.getColumnIndex(node),GridPane.getRowIndex(node));
				if (this.getColNum() == 10) {
					GridPane.setRowIndex(node, GridPane.getRowIndex(node) - 1);
					
					
					
				} else if (this.getColNum() == 0) {
					GridPane.setRowIndex(node, GridPane.getRowIndex(node) + 1);
					
					
				}
				
			}
			if (node instanceof Circle && (GridPane.getRowIndex(node) == this.getColNum())){//jobbal
				System.out.printf("2col:%d row:%d\n",GridPane.getColumnIndex(node),GridPane.getRowIndex(node));
				if (this.getRowNum() == 10) {
					GridPane.setColumnIndex(node, GridPane.getColumnIndex(node) - 1);
					
					
					
				} else if (this.getRowNum() == 0) {
					GridPane.setColumnIndex(node, GridPane.getColumnIndex(node) + 1);
					
					
				}
			}
		}
	}

	public boolean isClickable(Board board){
		
		if(this.getColNum() == 0){
			
				if(board.getNodeByCoords(this.getColNum()+9, this.getRowNum()).isEmpty()){
					return true;
				}else{
					return false;
				}
			
			
			
		}
		if(this.getColNum() == 10){
			
			if(board.getNodeByCoords(this.getColNum()-9, this.getRowNum()).isEmpty()){
				return true;
			}else{
				return false;
			}
		}
		if(this.getRowNum() == 0){
			if(board.getNodeByCoords(this.getColNum(), this.getRowNum()+9).isEmpty()){
				return true;
			}else{
				return false;
			}
		}
		if(this.getRowNum() == 10){
			if(board.getNodeByCoords(this.getColNum(), this.getRowNum()-9).isEmpty()){
				return true;
			}else{
				return false;
			}
		}
		return false;
		
	}



}
