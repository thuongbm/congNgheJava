import java.io.*;
import java.util.*;

class ThiSinh {
    private final String hoDem;
    private final String ten;
    private final String ngaySinh;

    public ThiSinh(String hoDem, String ten, String ngaySinh) {
        this.hoDem = hoDem;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hoDem, ten, ngaySinh);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ThiSinh that = (ThiSinh) obj;
        return hoDem.equals(that.hoDem) && ten.equals(that.ten) && ngaySinh.equals(that.ngaySinh);
    }

    @Override
    public String toString() {
        return hoDem + " " + ten + " (" + ngaySinh + ")";
    }
}

public class QuanLyThiSinh {
    public static void main(String[] args) {
        String inputFile = "ThiSinhIn.txt";
        String outputFile = "ThiSinhOut.txt";
        Hashtable<ThiSinh, TreeMap<String, Double>> danhSachThiSinh = new Hashtable<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    String hoDem = parts[0].trim();
                    String ten = parts[1].trim();
                    String ngaySinh = parts[2].trim();
                    ThiSinh ts = new ThiSinh(hoDem, ten, ngaySinh);
                    TreeMap<String, Double> diemThi = new TreeMap<>();
                    
                    for (int i = 3; i < parts.length; i += 2) {
                        String mon = parts[i].trim();
                        double diem = Double.parseDouble(parts[i + 1].trim());
                        diemThi.put(mon, diem);
                    }
                    danhSachThiSinh.put(ts, diemThi);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            for (ThiSinh ts : danhSachThiSinh.keySet()) {
                bw.write(ts.toString() + "\n");
                TreeMap<String, Double> diemThi = danhSachThiSinh.get(ts);
                for (Map.Entry<String, Double> entry : diemThi.entrySet()) {
                    bw.write("  " + entry.getKey() + ": " + entry.getValue() + "\n");
                }
                bw.newLine();
            }
            System.out.println("Xuất dữ liệu thành công vào " + outputFile);
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }
}
