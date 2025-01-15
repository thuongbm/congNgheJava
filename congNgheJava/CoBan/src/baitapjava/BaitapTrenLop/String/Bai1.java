package baitapjava.BaitapTrenLop.String;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.replace("a", "");
        System.out.println(s);
        sc.close();
    }
}
