package baitapjava.truoc;

import java.util.Scanner;

public class cau22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] a = new int[n];
        for (int i = 0 ; i < n ; i++){
            a[i] = scanner.nextInt();
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0 ; i < n ; i++){
            if (a[i] % 4 == 0){
                max = Math.max(max, a[i]);
            }
        }
        if (max == Integer.MIN_VALUE){
            System.out.println("Khong co phan tu nao chia het cho 4");
        }
        else System.out.println(max);
        scanner.close();
    }
}
