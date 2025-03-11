package Baitap.ThucHanh2;

import Baitap.ThucHanh2.Paint2D.Circle2D;
import Baitap.ThucHanh2.Paint2D.IShapeT;
import Baitap.ThucHanh2.Paint2D.IShapeO;
import Baitap.ThucHanh2.Paint2D.Point2D;

public class Test {

	public static void main(String[] args) {
		IShapeO[] list = {new Point2D(10, 10), new Point2D(5, 20),
				new Circle2D(new Point2D(-10, 2), 6)};
		
		// Operation
		double S = 0;
		for (IShapeO shape : list) {
			S += shape.distance();
		}
		System.out.println(S);
		
		// Transformation
//		for (IShapeO shape : list) {
//			shape.move(5, 5);
//		}

	}

}
