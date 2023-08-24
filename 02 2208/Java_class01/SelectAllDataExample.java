package Java_class01;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class SelectAllDataExample {
    private static final String URL = "jdbc:mysql://localhost:3306/liemdv";
    private static final String USER = "liemdv";
    private static final String PASSWORD = "TCB456tcb@";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            if (connection != null) {
                System.out.println("Mở lên làm  quần què gì. kết quả tìm kiếm nè!");

                // Thực hiện truy vấn SELECT *
                String selectSql = "SELECT * FROM Student where id=5";
                try (PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
                     ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        // Đọc dữ liệu từ ResultSet
                        int id = resultSet.getInt("ID");
                        String firstName = resultSet.getString("FirstName");
                        String lastName = resultSet.getString("LastName");
                        String address = resultSet.getString("Address");
                        String sex = resultSet.getString("Sex");
                        String majors = resultSet.getString("Majors");

                        // Xử lý dữ liệu ở đây
                        System.out.println("ID: " + id + ", FirstName: " + firstName + ", LastName: " + lastName +
                                           ", Address: " + address + ", Sex: " + sex + ", Majors: " + majors);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối hoặc truy vấn: " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Lỗi khi đóng kết nối: " + e.getMessage());
            }
        }
    }
}

