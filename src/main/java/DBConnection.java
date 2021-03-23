import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static String dbhost = "jdbc:mysql://localhost:3306/projektjzupa";
    private static String username = "test";
    private static String password = "12345";
    private static Connection conn;
    public static Connection createNewDBconnection() {
        try  {
            conn = DriverManager.getConnection(
                    dbhost, username, password);
            System.out.println("Działa połączenie");
        } catch (SQLException e) {
            System.out.println("Coś się- coś się popsuło");
            e.printStackTrace();
        } finally {
            return conn;
        }
    }
}