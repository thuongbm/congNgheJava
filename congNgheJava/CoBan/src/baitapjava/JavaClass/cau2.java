package baitapjava.JavaClass;

import java.util.Scanner;

public class cau2 {
    public static class Qlh{
        private String maHang, tenHang, xuatXu;
        private int loaiHang;

        public void Nhap(){
            Scanner scanner = new Scanner(System.in);

            System.out.println("Nhap cac gia tri cua hang hoa: ");

            maHang =  scanner.nextLine();
            tenHang = scanner.nextLine();
            xuatXu = scanner.nextLine();
            loaiHang = scanner.nextInt();
            scanner.nextLine();
        }

        public void Xuat(){
            System.out.print(maHang  +  ' ' + tenHang + ' ' + xuatXu + ' ' + loaiHang);
        }
    }

    public static void main (String[] arg){
        Qlh hangHoa = new Qlh();
        hangHoa.Nhap();
        hangHoa.Xuat();
    }
}