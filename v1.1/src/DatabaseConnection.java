import java.sql.*;

public class DatabaseConnection {
    Connection DatabaseConnection() {
        System.out.println("Database connection is initiated.");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection conn;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://aws.connect.psdb.cloud/food-storage?sslMode=VERIFY_IDENTITY",
                    "u8w1yriboprsqnjsqe2o",
                    "pscale_pw_xZ2shSUTsCF70kBJIyJ0l21LCqRvOt72ZXangjDN43J");

            System.out.println("Database is connected succesfully.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;/*Returning connection object foe further calling*/
    }
}
