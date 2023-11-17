
import java.sql.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Connection conn;
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://aws.connect.psdb.cloud/food-storage?sslMode=VERIFY_IDENTITY",
                    "btvaekg2lf6pmzgapteb",
                    "pscale_pw_JCN36oqg9qvdqkJbdcEDBaE8HsVm9NXWDqjkZ9wc5mO");
            System.out.println("Database is connected succesfully.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Statement stmt;
        try {
            stmt = conn.createStatement();
//            stmt.executeUpdate("Create table stud2(cno varchar(5) ,r_no int(4),name varchar(50),score int(5) ,gender varchar(2) ,category varchar(10),class varchar(5) ,Address varchar(15));");
//            System.out.println("table created");
//            stmt.executeUpdate("insert into stud2 values('AA',1,'Ganesh',99,'M','Open','B','swarg');");
//            System.out.println("value inserted");
//sss
//            stmt.executeUpdate("insert into stud2 values('CC',7,'Shree',99,'M','OPEN','B','swarg')");
//
//            stmt.executeUpdate("insert into stud2 values('CC',5,'Vinayak',99,'M','OPEN','B','swarg')");
//
//            stmt.executeUpdate("insert into stud2 values('EE',9,'Surpa',65,'F','NT','F','Hell')");
//
//            stmt.executeUpdate("insert into stud2 values('MM',4,'devil',66,'M','NT','F','Hell')");
//
//            stmt.executeUpdate("insert into stud2 values('EE',8,'Varun',59,'M','SBC','S','Darbar')");
//
//            stmt.executeUpdate("insert into stud2 values('MM',6,'Kiran',49,'M','SC','T','Darbarnew')");
//

            //Showing group by clause
//            ResultSet rs1=stmt.executeQuery("select cno,max(r_no) from stud2 group by cno");
            ResultSet rs1=stmt.executeQuery("select * from stud2 ");
            try
            {

                while(rs1.next())
                {

                    System.out.print(rs1.getString(1));

                    System.out.print("\t"+rs1.getInt(2));

                    System.out.println("\t"+rs1.getString(3));
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }
}