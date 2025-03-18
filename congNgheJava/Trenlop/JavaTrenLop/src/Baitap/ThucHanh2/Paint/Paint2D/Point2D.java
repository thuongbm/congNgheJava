package Baitap.ThucHanh2.Paint.Paint2D;

public class Point2D implements IShapeT, IShapeO{
    private double x;
    private double y;

    public Point2D() {
        this.x = 0;
        this.y = 0;
    }

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void display() {
        System.out.println("(" + this.x + ", " + this.y + ")");
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distance(){
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public void move(double dx, double dy){
        this.x += dx;
        this.y += dy;
    }

    public void rotate(double alpha){
        return;
    }

    public void zoom(double ratio){
        return;
    }

    public double perimeter(){
        return 0;
    }

    public double area(){
        return 0;
    }

    public void set(double x, double y){
        this.x = x;
        this.y = y;
    }
}
