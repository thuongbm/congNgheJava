package hocTrenLop.buoi1;

public class Bai4 {
    public static void main(String[] args){
        int[] a = {1, 3, 9, 6, 5};
        int S = 0;

        for (int x : a){
            if (x % 3 == 0) S += x;
        }

        System.out.println(S);
    }
}
