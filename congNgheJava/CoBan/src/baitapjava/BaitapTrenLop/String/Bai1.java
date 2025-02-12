package baitapjava.BaitapTrenLop.String;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        String s = "Lap trinh java khong don gian";
        s = s.replace("a", "");
        s = reverseString(s);
        System.out.println(s);
    }

    public static String reverseString (String s){
        return new StringBuilder(s).reverse().toString();
    }
}
