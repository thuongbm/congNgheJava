package Baitap.ThucHanh2.Paint.Paint2D;

public class Test {
    public static void main(String[] args) {
        Point2D p1 = new Point2D(1, 2);
        p1.display();
        p1.move(3, 4);
        p1.display();
        System.out.println(p1.distance());
    }
}
