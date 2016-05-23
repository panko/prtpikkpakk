package hu.unideb.inf.prt.pikkpakk.model;
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
	
//	public int getColNum(){
//		return (int)this.getLayoutX() / 33;
//	}
//	public int getRowNum(){
//		return (int)this.getLayoutY() / 33;
//	}

}
