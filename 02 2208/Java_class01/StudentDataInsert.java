package Java_class01;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDataInsert {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            if (connection != null) {
                System.out.println("Kết nối thành công!");

                // Thêm đối tượng Student vào CSDL
                Student student = new Student(1, "John", "Doe", "123 Main St", "Male", "Computer Science");

                String insertSql = "INSERT INTO students (ID, FirstName, LastName, Address, Sex, Majors) VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
                    preparedStatement.setInt(1, student.getID());
                    preparedStatement.setString(2, student.getFirstName());
                    preparedStatement.setString(3, student.getLastName());
                    preparedStatement.setString(4, student.getAddress());
                    preparedStatement.setString(5, student.getSex());
                    preparedStatement.setString(6, student.getMajors());

                    int rowsInserted = preparedStatement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("Thêm dữ liệu Student thành công!");
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi kết nối hoặc thêm dữ liệu: " + e.getMessage());
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
