package Baitap.ThucHanh2.Paint.Paint2D.Line;

import Baitap.ThucHanh2.Paint.Paint2D.Point2D;

public class Lines implements ILineT, ILineO{
    private Point2D x;
    private Point2D y;

    public Lines() {
        this.x = new Point2D();
        this.y = new Point2D();
    }

    public void display() {
        System.out.println("Line from " + this.x + " to " + this.y);
    }

    public void move(Point2D p1, Point2D p2) {
        this.x = p1;
        this.y = p2;
    }

    @Override
    public double zoom(double alpha) {
        Lines l = new Lines();
        l.x = this.x;
        l.y = this.y;
        return alpha * l.length();
    }

    public double length(){
        return Math.sqrt((this.x.getX() - this.y.getX()) * (this.x.getX() - this.y.getX()) + (this.x.getY() - this.y.getY()) * (this.x.getY() - this.y.getY()));
    }

    public void move(double dx, double dy) {
        this.x.move(dx, dy);
        this.y.move(dx, dy);
    }

    public double area() {
        return 0;
    }

    public double perimeter() {
        return 0;
    }

    public void ratito(double alpha) {
        double radian = Math.toRadians(alpha);

        Point2D mid = new Point2D((this.x.getX() + this.y.getX()) / 2, (this.x.getY() + this.y.getY()) / 2);

        Point2D result1 = new Point2D(this.x.getX() * Math.acos(radian) - this.x.getY() * Math.asin(radian) + mid.getX(), this.x.getY() * Math.asin(radian) + this.x.getX() * Math.acos(radian) + mid.getY());
        Point2D result2 = new Point2D(this.y.getX() * Math.acos(radian) - this.y.getY() * Math.asin(radian) + mid.getX(), this.y.getY() * Math.asin(radian) + this.y.getX() * Math.acos(radian) + mid.getY());

        this.x = result1;
        this.y = result2;
    }
}
