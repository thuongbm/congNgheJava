package baitapjava.truoc;

import java.util.Scanner;

public class cau6 {
    public static void main(String[] args) {
        System.out.print("Nhap 3 so a, b: ");
        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();

        double res = Math.pow(a, 3) + Math.sqrt(b + 1);

        System.out.println("Gia tri cua bieu thuc la: " + res);
        scanner.close();
    }
}
