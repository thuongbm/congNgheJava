package Baitap.ThucHanh2.Paint.Paint2D.Line;

import Baitap.ThucHanh2.Paint.Paint2D.Point2D;

public interface ILineT {
    void move(Point2D p1, Point2D p2);

    void display();

    double zoom(double alpha);

    void ratito(double alpha);
}
