import java.sql.*;

public class DatabaseConnection {
    public Connection connectDatabase(){
        System.out.println("'connectDatabase' function called.\nDatabase connection is initiated.");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection conn;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://aws.connect.psdb.cloud/food-storage?sslMode=VERIFY_IDENTITY",
                    "074nlu6zlor400of7hko",
                    "pscale_pw_rSofrsvn346jO2fAfONQaMLEltMcxH8IfAQFBwgPZs2");

            System.out.println("Database is connected succesfully.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
