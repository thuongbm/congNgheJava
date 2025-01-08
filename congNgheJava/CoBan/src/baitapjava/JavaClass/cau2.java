package baitapjava.JavaClass;

import java.util.Scanner;

public class cau2 {
    // Lớp quản lý hàng hóa
    public static class Qlh {
        private String maHang, tenHang, xuatXu;
        private int loaiHang;

        // Phương thức nhập dữ liệu
        public void Nhap(Scanner scanner) {
            System.out.println("Nhập mã hàng: ");
            maHang = scanner.nextLine();
            System.out.println("Nhập tên hàng: ");
            tenHang = scanner.nextLine();
            System.out.println("Nhập xuất xứ: ");
            xuatXu = scanner.nextLine();
            System.out.println("Nhập loại hàng (số nguyên): ");
            loaiHang = scanner.nextInt();
            scanner.nextLine(); // Xử lý ký tự xuống dòng thừa
        }

        // Phương thức xuất dữ liệu
        public void Xuat() {
            System.out.println(maHang + " " + tenHang + " " + xuatXu + " " + loaiHang);
        }

        // Getter cho loaiHang
        public int getLoaiHang() {
            return loaiHang;
        }
    }

    // Lớp DiemTu kế thừa Qlh
    public static class DiemTu extends Qlh {
        private int Tgbh; // Thời gian bảo hành

        // Phương thức nhập thêm thời gian bảo hành
        public void Input(Scanner scanner) {
            System.out.println("Nhập thời gian bảo hành (số nguyên): ");
            Tgbh = scanner.nextInt();
            scanner.nextLine(); // Xử lý ký tự xuống dòng thừa
            Nhap(scanner);
        }

        // Phương thức xuất thông tin bao gồm thời gian bảo hành
        public void Output() {
            System.out.print("Thời gian bảo hành: " + Tgbh + " ");
            Xuat();
        }
    }

    // Phương thức main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập và xuất thông tin cho hàng hóa thông thường
        System.out.println("Nhập thông tin hàng hóa thông thường:");
        Qlh hangHoa = new Qlh();
        hangHoa.Nhap(scanner);
        System.out.println("Thông tin hàng hóa vừa nhập:");
        hangHoa.Xuat();

        // Nhập và xuất thông tin cho hàng hóa điện tử
        System.out.println("\nNhập thông tin hàng hóa điện tử:");
        DiemTu hangDienTu = new DiemTu();
        hangDienTu.Input(scanner);
        System.out.println("Thông tin hàng hóa điện tử vừa nhập:");
        hangDienTu.Output();

        scanner.close();
    }
}
