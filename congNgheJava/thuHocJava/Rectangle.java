// package thuHocJava;

import java.util.Scanner;

public class Rectan4gle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap chieu dai: ");
        int a = scanner.nextInt();

        System.out.print("Nhap chieu rong: ");
        int b = scanner.nextInt();

        System.out.print("Dien tich hinh chu nhat la: " + a * b);

        scanner.close();
    }
}
