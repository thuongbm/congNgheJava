package hocTrenLop.buoi1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class test {

    // Địa chỉ cơ sở dữ liệu SQLite (có thể thay đổi đường dẫn tệp DB nếu cần)
    private static final String DB_URL = "jdbc:sqlite:students.db";

    // Kết nối đến cơ sở dữ liệu SQLite
    public static Connection connect() {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.err.println("Không thể kết nối đến cơ sở dữ liệu.");
            e.printStackTrace();
            return null;
        }
    }

    // Tạo bảng nếu chưa có
    public static void createTable() {
        // Câu lệnh SQL để tạo bảng
        String createTableSQL = "CREATE TABLE IF NOT EXISTS student (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "age INTEGER NOT NULL" +
                ");";

        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            // Thực thi câu lệnh SQL
            stmt.execute(createTableSQL);
            System.out.println("Bảng 'student' đã được tạo hoặc đã tồn tại.");
        } catch (SQLException e) {
            System.err.println("Lỗi khi tạo bảng.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Gọi phương thức tạo bảng khi chương trình chạy
        createTable();
    }
}
