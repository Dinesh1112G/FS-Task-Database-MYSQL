import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class EmployeeInsert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/employeeDB"; 
        String user = "root"; 
        String password = "#Dinu1112";  

        try {
            // 1. Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish Connection
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Database connected successfully!");

            // 3. Prepare Insert Query
            String query = "INSERT INTO employee (empcode, empname, empage, esalary) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);

            // 4. Insert multiple rows
            Object[][] employees = {
                {101, "Jenny", 25, 10000},
                {102, "Jacky", 30, 20000},
                {103, "Joe", 20, 40000},
                {104, "John", 40, 80000},
                {105, "Shameer", 25, 90000}
            };

            for (Object[] emp : employees) {
                pstmt.setInt(1, (int) emp[0]);
                pstmt.setString(2, (String) emp[1]);
                pstmt.setInt(3, (int) emp[2]);
                pstmt.setDouble(4, (double) ((Number) emp[3]).doubleValue());
                pstmt.executeUpdate();
            }

            System.out.println("✅ Records inserted successfully!");
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
