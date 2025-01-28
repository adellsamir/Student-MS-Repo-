package StudentSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
public class MainTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student_ms_database";
        String user = "root";
        String password = "";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to MySQL successfully!");
            String sqlCommand = "INSERT INTO student (student_rollNum, studentName, studentEmail,GPA,StudentLevel) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sqlCommand);
            pstmt.setInt(1, 99);
            pstmt.setString(2, "Recardo Kaka");
            pstmt.setString(3, "kaka22@gail.com");
            pstmt.setFloat(4,4.9F);
            pstmt.setInt(5,4);
            pstmt.executeUpdate();
            System.out.println("student added.");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
