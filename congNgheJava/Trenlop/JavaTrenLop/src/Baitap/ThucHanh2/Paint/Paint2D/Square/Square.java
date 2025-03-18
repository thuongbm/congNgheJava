package Baitap.ThucHanh2.Paint.Paint2D.Square;

import Baitap.ThucHanh2.Paint.Paint2D.Point2D;
import Baitap.ThucHanh2.Paint.Paint2D.Rectange.IRectangeT;
import Baitap.ThucHanh2.Paint.Paint2D.Rectange.IRectangeO;


public class Square implements IRectangeT, IRectangeO{
    private Point2D p;
    private double side;

    public Square(Point2D p, double side) {
        this.p = p;
        this.side = side;
    }

    public Point2D getP() {
        return p;
    }

    public void setP(Point2D p) {
        this.p = p;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public void move(Point2D p1) {
        this.p = p1;
    }

    public void zoom(double ratio) {
        side *= ratio;
    }

    public void ratito(double alpha) {
        double radians = Math.toRadians(alpha);

        Point2D mid = new Point2D(this.p.getX() + this.side / 2, this.p.getY() + this.side / 2);

        Point2D result = new Point2D((this.p.getX() * Math.acos(radians) - this.p.getY() * Math.asin(radians)) + mid.getX(), (this.p.getY() * Math.asin(radians) + this.p.getX() * Math.acos(radians)) + mid.getY());

        this.p = result;
    }

    public double area(){
        return this.side * this.side;
    }

    public double perimeter(){
        return 4 * this.side;
    }

    public String display() {
        return "Square{" + "p=" + p + ", side=" + side + '}';
    }
}
