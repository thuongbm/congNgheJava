package hocTrenLop.buoi1;

public class bai1 {
    public static void main (String[] args){
        double a = 5.0;
        double b = 7.0;
        double c = -2.0;

        double dx = (-10 * b + 7 * c);
        double dy = (a * c + 20);
        double d = (-a * b + 14);
        double x, y;

        if (d == 0){
            if (dx == 0 && dy == 0){
                System.out.println("Phuong trinh vo so nghiem");
            } else {
                System.out.println("Phuong trinh vo nghiem");
            }
        } else {
            x = dx / d;
            y = dy / d;
            System.out.println("Nghiem cua ohuong trinh la: ");

        }
    }
}
