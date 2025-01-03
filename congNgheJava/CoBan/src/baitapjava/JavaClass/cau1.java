package baitapjava.JavaClass;

import java.util.Scanner;

public class cau1 {
    public static class Innercau1 {
        private int tu;
        private int mau;
        
        public void nhap() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhap tu so: ");
            tu = scanner.nextInt(); // Nhập tử số
            System.out.print("Nhap mau so: ");
            mau = scanner.nextInt(); // Nhập mẫu số
            scanner.close();
        }

        public void xuat() {
            System.out.println("Phan so: " + tu + '/' + mau); // Hiển thị phân số
        }
    }

    public static void main(String[] args) {
        Innercau1 ps = new Innercau1();
        ps.nhap(); // Nhập dữ liệu
        ps.xuat(); // Xuất dữ liệu
    }
}
// package baitapjava.JavaClass;

// import java.util.Scanner;

// public class cau1 {
//     public static class Innercau1 {
//         private int tu;
//         private int mau;
        
//         public void  nhap(){
//             Scanner scanner = new Scanner(System.in);
//             tu = scanner.nextInt();
//             mau = scanner.nextInt();
//             scanner.close();
//         }

//         public void xuat(){
//             System.out.println(tu + '/' + mau);
//         }
//     }
//     public static void main(String[] args) {
//         Innercau1 ps = new Innercau1();
//         ps.nhap();
//         ps.xuat();

//     }


