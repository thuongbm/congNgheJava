package hocTrenLop.buoi1;

public class Bai3 {
    public static long Fibo(int n){
        if (n == 0 || n == 1) return 1;
        long res1 = 1;
        long res2 = 1;
        long res = 0;
        for (int i = 1 ; i < n ; i++){
            res = res1 + res2;
            res1 = res2;
            res2 = res;
        }
        return res;
    }
    public static void main(String[] args){
        int m = 7;
        for (int i = 0 ; i <= m ; i++){
            if (Fibo(i) <= m && Fibo(i+1) > m){
                System.out.println(i);
                break;
            }
        }
    }
}
