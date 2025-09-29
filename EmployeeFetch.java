import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeFetch {
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

            // 3. Create Statement
            Statement stmt = con.createStatement();

            // 4. Execute Query
            String query = "SELECT * FROM employee";
            ResultSet rs = stmt.executeQuery(query);

            // 5. Print Results
            System.out.println("\n--- Employee Table ---");
            System.out.printf("%-8s %-10s %-6s %-10s\n", "Code", "Name", "Age", "Salary");
            System.out.println("-------------------------------------");

            while (rs.next()) {
                int code = rs.getInt("empcode");
                String name = rs.getString("empname");
                int age = rs.getInt("empage");
                double salary = rs.getDouble("esalary");

                System.out.printf("%-8d %-10s %-6d %-10.2f\n", code, name, age, salary);
            }

            // 6. Close
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
