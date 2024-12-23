package baitapjava;

import java.util.Scanner;

public class cau4 {
    public static void main(String[] args) {
        System.out.println("Nhap 3 so de tinh bieu thuc");

        Scanner scanner = new Scanner(System.in);

        float a = scanner.nextFloat();
        float b = scanner.nextFloat();
        float c = scanner.nextFloat();

        double res = Math.pow(Math.pow(a, 3) + b, 3) + c;

        System.out.println("\n" + res);

        scanner.close();

    }
}
