package baitapjava.truoc;

import java.util.Scanner;

public class cau13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int [] a = new int[n];
        
        for (int i = 0 ; i < n ; i++){
            a[i] = scanner.nextInt();
        }

        for (int x : a){
            System.out.print(x);
            System.out.print(" ");
        }

        scanner.close();
    }
}
