package Baitap.ThucHanh2.Paint.Paint2D.Rectange;

import Baitap.ThucHanh2.Paint.Paint2D.Point2D;

public interface IRectangeT {
    void move(Point2D p1);

    String display();

    void zoom(double alpha);

    void ratito(double alpha);
}
