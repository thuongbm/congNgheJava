package Baitap.ThucHanh2.Paint.Paint2D.Circle;

import Baitap.ThucHanh2.Paint.Paint2D.Point2D;
import Baitap.ThucHanh2.Paint.Paint2D.IShapeT;
import Baitap.ThucHanh2.Paint.Paint2D.IShapeO;



public class Circles implements IShapeT, IShapeO{
    private Point2D p;
    private double radius;

    public Circles(Point2D p, double radius) {
        this.p = p;
        this.radius = radius;
    }

    public Point2D getP() {
        return p;
    }

    public void setP(Point2D p) {
        this.p = p;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String display() {
        return "Circles{" + "p=" + p + ", radius=" + radius + '}';
    }

    public void move(Point2D p){
        this.p = p;
    }

    public void rotate(double alpha) {

    }

    public void zoom(double ratio) {
        this.radius *= ratio;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public double distance() {
        return 0;
    }

    @Override
    public void move(double dx, double dy) {

    }
}
