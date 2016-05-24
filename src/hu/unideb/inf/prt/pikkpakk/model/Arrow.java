package hu.unideb.inf.prt.pikkpakk.model;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.BooleanPropertyBase;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

public class Arrow extends Polygon{
	
	private boolean isClicked;

	public Arrow() {
		super();
		isClicked = false;
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
					this.setIsClicked(true);
					board.getArrowByCoords(getRowNum(), 0).setIsClicked(false);
					
				} else if (this.getColNum() == 0) {
					GridPane.setRowIndex(node, GridPane.getRowIndex(node) + 1);
					this.setIsClicked(true);
					board.getArrowByCoords(getRowNum(), 10).setIsClicked(false);
				}
				
			}
			if (node instanceof Circle && (GridPane.getRowIndex(node) == this.getColNum())){//jobbal
				System.out.printf("2col:%d row:%d\n",GridPane.getColumnIndex(node),GridPane.getRowIndex(node));
				if (this.getRowNum() == 10) {
					GridPane.setColumnIndex(node, GridPane.getColumnIndex(node) - 1);
					this.setIsClicked(true);
					board.getArrowByCoords(getColNum(), 0).setIsClicked(false);
					
				} else if (this.getRowNum() == 0) {
					GridPane.setColumnIndex(node, GridPane.getColumnIndex(node) + 1);
					this.setIsClicked(true);
					board.getArrowByCoords(getColNum(), 10).setIsClicked(false);
				}
			}
		}
	}

	public boolean getIsClicked() {
		return isClicked;
	}

	public void setIsClicked(boolean isClicked) {
		this.isClicked = isClicked;
	}



}
