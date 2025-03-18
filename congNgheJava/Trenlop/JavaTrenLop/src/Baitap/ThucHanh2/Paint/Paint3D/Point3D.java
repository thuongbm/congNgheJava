package Baitap.ThucHanh2.Paint.Paint3D;

import Baitap.ThucHanh2.Paint.Paint2D.Point2D;

public class Point3D extends Baitap.ThucHanh2.Paint.Paint2D.Point2D implements IPoint3D{
    private double z;

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public void getXYZ() {
        System.out.println("(" + this.getX() + ", " + this.getY() + ", " + this.z + ")");
    }

    public void setXYZ(double x, double y, double z) {
        super.setX(x);
        super.setY(y);
        this.z = z;
    }

    public void display() {
        System.out.println("(" + this.getX() + ", " + this.getY() + ", " + this.z + ")");
    }

    public double distance() {
        return Math.sqrt(this.getX() * this.getX() + this.getY() * this.getY() + this.z * this.z);
    }

    public void move(double dx, double dy, double dz) {
        super.move(dx, dy);
        this.z += dz;
    }

    public void rotate(double alpha) {
        return;
    }

    public void zoom(double ratio) {
        return;
    }

    public double perimeter() {
        return 0;
    }

    public double area() {
        return 0;
    }

    public double volume() {
        return 0;
    }

}
