package hocTrenLop.buoi1;

public class Bai2 {
    public static long GiaiThua(int n){
        int res = 0;
        for (int i = 1 ; i <= n; i++){
            res *= i;
        }
        return res;
    }

    public static void main (String[] args){
        int n = 7;
        double S = 0;
        for (int i = 1; i <= n; i++){
            S += ((i + Math.sqrt(i)) / (i + GiaiThua(i + 1)));
        }

        System.out.printf("%.2f", S);
    }
}
