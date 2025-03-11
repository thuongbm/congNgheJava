package Baitap.ThucHanh2.Paint2D;

public class Circle2D implements IShapeO, IShapeT {

	private Point2D c;
	private double r;

	public Circle2D(Point2D c, double r) {
		super();
		this.c = c;
		this.r = r;
	}

	public Point2D getC() {
		return c;
	}

	public void setC(Point2D c) {
		this.c = c;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	@Override
	public String toString() {
		return "Circle2D [c=" + super.toString() + ", r=" + r + "]";
	}

	@Override
	public double area() {
		return Math.PI * this.r * this.r;
	}

	@Override
	public double perimeter() {
		return Math.PI * this.r * 2.0;
	}

	@Override
	public double distance() {
		return this.c.distance();
	}

	@Override
	public void move(double dx, double dy) {
		this.c.move(dx, dy);
	}

	@Override
	public void rotate(double alpha) {
		return;
	}

	@Override
	public void zoom(double ratio) {
		this.r *= ratio;
		
	}

}
