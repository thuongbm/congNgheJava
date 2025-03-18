package Baitap.ThucHanh2.Paint.Paint2D.Rectange;

import Baitap.ThucHanh2.Paint.Paint2D.Point2D;

public class Rectanges implements IRectangeT, IRectangeO{
    private Point2D p;
    private double width;
    private double height;

    public Rectanges(Point2D p, double width, double height) {
        this.p = p;
        this.width = width;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public Point2D getP() {
        return p;
    }

    public String display() {
        return "Rectanges{" + "p=" + p + ", width=" + width + ", height=" + height + '}';
    }

    public void move(Point2D p1) {
        this.p = p1;
    }

    public void zoom(double alpha) {
        this.height = this.height * alpha;
        this.width = this.width * alpha;
    }

    public double area(){
        return this.width * this.height;
    }

    public double perimeter(){
        return 2 * (this.width + this.height);
    }

    public void ratito(double alpha){
        double radians = Math.toRadians(alpha);

        Point2D mid = new Point2D((this.p.getX() + this.width) / 2, (this.p.getY() + this.height) / 2);

        Point2D result = new Point2D((this.p.getX() * Math.acos(radians) - this.p.getY() * Math.asin(radians)) + mid.getX(), (this.p.getY() * Math.asin(radians) + this.p.getX() * Math.acos(radians)) + mid.getY());

        this.p = result;
    }
}
