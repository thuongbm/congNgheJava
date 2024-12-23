package baitapjava;

import java.util.Scanner;

public class cau36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] a = new int[n];

        for (int i = 0 ; i < n ; i++){
            a[i] = scanner.nextInt();
        }

        int x = scanner.nextInt();

        int res = check(a, x);

        System.out.println(res);

        scanner.close();
    }

    public static int check(int a[], int x){
        int cnt = 0;
        for (int y : a){
            if (y % x  == 0){
                cnt++;
            }
        }
        return cnt;
    }
}
