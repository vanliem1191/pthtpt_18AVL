package Java_class01;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {
        School school = new School();

        school.addPerson(new Student(3, "Dương Văn", "Liêm", "123 Hẻm xóm núi", "Nam", "CNTT"));
        school.addPerson(new Student(4, "Vũ Văn", "Quân", "456 Đường xóm chùa", "Nữ", "Kinh tế"));
        school.addPerson(new Student(5, "Trần Nhật", "Vượng", "789 Ngõ xóm bụi", "Nam", "Vật lý"));

        school.addPerson(new Teacher(101, "Thầy", "Trần Văn A", "115 Đại học IUH", "Nam", "Tiến sĩ"));
        school.addPerson(new Teacher(102, "Cô", "Nguyễn Thị B", "226 Trường ĐH Quốc Gia TP-HCM", "Nữ", "Thạc sĩ"));
        
        System.out.println("List of Students and Teachers:");
        school.listAllPeople();

        // Kết nối đến cơ sở dữ liệu
        Connection connection = null;
        try {
            String jdbcURL = "jdbc:mysql://localhost:3306/liemdv";
            String jdbcUsername = "liemdv";
            String jdbcPassword = "TCB456tcb@";
            
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            if (connection != null) {
                System.out.println("Connected to the database!");
                
                // Chèn thông tin học sinh vào CSDL
                for (Person person : school.getPeople()) {
                    if (person instanceof Student) {
                        Student student = (Student) person;
                        String insertSql = "INSERT INTO student (ID, FirstName, LastName, Address, Sex, Majors) VALUES (?, ?, ?, ?, ?, ?)";
                        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
                            preparedStatement.setInt(1, student.getID());
                            preparedStatement.setString(2, student.getFirstName());
                            preparedStatement.setString(3, student.getLastName());
                            preparedStatement.setString(4, student.getAddress());
                            preparedStatement.setString(5, student.getSex());
                            preparedStatement.setString(6, student.getMajors());

                            int rowsInserted = preparedStatement.executeUpdate();
                            if (rowsInserted > 0) {
                                System.out.println("Inserted Student: " + student.getFullName());
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Rest of your code
    }
}
