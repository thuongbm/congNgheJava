package Baitap.ThucHanh2.Paint.Paint3D;

public interface IPoint3D {
    public double getZ();
    public void setZ(double z);
    public void getXYZ();
    public void setXYZ(double x, double y, double z);
    public void display();
    public double distance();
    public void move(double dx, double dy, double dz);
    public void rotate(double alpha);
    public void zoom(double ratio);
    public double perimeter();
    public double area();
    public double volume();
}
