package Baitap.ThucHanh2.Paint.Paint2D;

public interface IShapeT {
    public void move(double dx, double dy);

    public void rotate(double alpha);

    public void zoom(double ratio);

    public double distance();
}
