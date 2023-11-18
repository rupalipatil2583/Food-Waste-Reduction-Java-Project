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
                    "7l634u4pq7hu2hghze6q",
                    "pscale_pw_ss8c3o62Sw2O4QV2ZdowMc89yM5oP7CbjI2ufvRxchI");

            System.out.println("Database is connected succesfully.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;/*Returning connection object foe further calling*/
    }
}
