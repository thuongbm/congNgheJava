package Baitap.ThucHanh2.Paint.Paint2D.Triangle;

import Baitap.ThucHanh2.Paint.Paint2D.Point2D;
import Baitap.ThucHanh2.Paint.Paint2D.Rectange.IRectangeT;
import Baitap.ThucHanh2.Paint.Paint2D.Rectange.IRectangeO;


public class Triangles implements IRectangeT, IRectangeO {
    private Point2D point2D;
    private double side1;
    private double side2;
    private double side3;

    public Triangles (Point2D point2D, double side1, double side2, double side3) {
        this.point2D = point2D;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Point2D getPoint2D() {
        return point2D;
    }

    public void setPoint2D(Point2D point2D) {
        this.point2D = point2D;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public String display() {
        return "Triangles{" + "point2D=" + point2D + ", side1=" + side1 + ", side2=" + side2 + ", side3=" + side3 + '}';
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double area() {
        double p = (side1 + side2 + side3) / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    public double perimeter() {
        return side1 + side2 + side3;
    }

    public void move(Point2D point2D) {
        this.point2D = point2D;
    }

    public void zoom(double ratio) {
        side1 *= ratio;
        side2 *= ratio;
        side3 *= ratio;
    }

    public void ratito(double alpha) {
        double radians = Math.toRadians(alpha);

        Point2D p2 = new Point2D(this.side2, 0);
        Point2D p3 = new Point2D(this.side2 * this.side2 + this.side3 * this.side3 - this.side1 * this.side1, Math.sqrt(Math.abs(side3 * side3 - this.side2 * this.side2 + this.side3 * this.side3 - this.side1 * this.side1 * this.side2 * this.side2 + this.side3 * this.side3 - this.side1 * this.side1)));

        //trung điểm của 2 cạnh
        Point2D mid12 = new Point2D((this.point2D.getX() + p2.getX()) / 2, this.point2D.getY() + p2.getY() / 2);
        Point2D mid23 = new Point2D((p2.getX() + p3.getX()) / 2, (p2.getY() + p3.getY()) / 2);

        //hệ số góc
        double mPerp12 = (p2.getY() - this.point2D.getY()) / (p2.getX() - this.point2D.getX());
        double mPerp23 = (p3.getY() - p2.getY()) / (p3.getX() - p2.getX());

        //hệ số góc đường trung trực
        double mMid12 = -1 / mPerp12;
        double mMid23 = -1 / mPerp23;

        //giao điểm của 2 đường trung trực
        double x = (mPerp12 * mid12.getX() - mPerp23 * mid23.getX() + mid23.getY() - mid12.getY()) / (mPerp12 - mPerp23);
        double y = mMid12 * (x - mid12.getX()) + mid12.getY();
        Point2D G = new Point2D(x, y);

        //xoay tử trọng tâm
        Point2D result1 = new Point2D((this.point2D.getX() * Math.cos(radians) - this.point2D.getY() * Math.sin(radians)) + G.getX(), (this.point2D.getY() * Math.sin(radians) + this.point2D.getX() * Math.cos(radians)) + G.getY());
        this.point2D = result1;
    }
}
