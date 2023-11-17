
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseConnection D = new DatabaseConnection();
        Connection conn = D.connectDatabase();

//        SignUpRegister S = new SignUpRegister();
//        S.chooseOption(conn);
//
        Statement stmt;
        try {
            stmt = conn.createStatement();
//            stmt.executeUpdate("CREATE TABLE Hotel(HotelID int NOT NULL,HotelName varchar(255),HotelUserName varchar(255) UNIQUE NOT NULL,HotelMail varchar(255) UNIQUE NOT NULL,HotelPassword varchar(255) NOT NULL,HotelAddress varchar(255) NOT NULL,HotelCity varchar(255) NOT NULL,HotelContact int NOT NULL ,PRIMARY KEY (HotelUserName,HotelMail));");
//            stmt.executeUpdate("CREATE TABLE Trust(TrustID int NOT NULL,TrustName varchar(255),TrustUserName varchar(255) UNIQUE NOT NULL,TrustMail varchar(255) UNIQUE NOT NULL,TrustPassword varchar(255) NOT NULL,TrustAddress varchar(255) NOT NULL,TrustCity varchar(255) NOT NULL,TrustContact int NOT NULL ,PRIMARY KEY (TrustUserName,TrustMail));");
//            stmt.executeUpdate("CREATE TABLE Delivery(DeliveryID int NOT NULL,DeliveryName varchar(255),DeliveryUserName varchar(255) UNIQUE NOT NULL,DeliveryMail varchar(255) UNIQUE NOT NULL,DeliveryPassword varchar(255) NOT NULL,DeliveryAddress varchar(255) NOT NULL,DeliveryCity varchar(255) NOT NULL,DeliveryContact int NOT NULL ,PRIMARY KEY (DeliveryUserName,DeliveryMail));");
//



//            stmt.executeUpdate("Drop table Hotel;");
//            stmt.executeUpdate("Drop table Trust;");
//            stmt.executeUpdate("Drop table Delivery;");


//            stmt.executeUpdate("insert into Hotel values(1,'hotel1','hy1','hfhf1@gmai.com','qweqwe1','sangli1','sangli1',11111);");
//            stmt.executeUpdate("insert into Hotel values(2,'hotel2','hy2','hfhf2@gmai.com','qweqwe2','sangli2','sangli2',22222);");
//            stmt.executeUpdate("insert into Hotel values(3,'hotel3','hy3','hfhf3@gmai.com','qweqwe3','sangli3','sangli3',33333);");
//            stmt.executeUpdate("insert into Hotel values(4,'hotel4','hy4','hfhf4@gmai.com','qweqwe4','sangli4','sangli4',44444);");

//            try {
//                ResultSet rs1=stmt.executeQuery("SELECT HotelID FROM Hotel ORDER BY HotelID DESC");
//                int HotelID =;
//                System.out.println( rs1.getInt(1));
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }

//            stmt.executeUpdate("Create table stud2(cno varchar(5) ,r_no int(4),name varchar(50),score int(5) ,gender varchar(2) ,category varchar(10),class varchar(5) ,Address varchar(15));");
//            System.out.println("table created");
////            stmt.executeUpdate("insert into stud2 values('AA',1,'Ganesh',99,'M','Open','B','swarg');");
////            System.out.println("value inserted");
////sss
////            stmt.executeUpdate("insert into stud2 values('CC',7,'Shree',99,'M','OPEN','B','swarg')");
////
////            stmt.executeUpdate("insert into stud2 values('CC',5,'Vinayak',99,'M','OPEN','B','swarg')");
////
////            stmt.executeUpdate("insert into stud2 values('EE',9,'Surpa',65,'F','NT','F','Hell')");
////
////            stmt.executeUpdate("insert into stud2 values('MM',4,'devil',66,'M','NT','F','Hell')");
////
////            stmt.executeUpdate("insert into stud2 values('EE',8,'Varun',59,'M','SBC','S','Darbar')");
////
////            stmt.executeUpdate("insert into stud2 values('MM',6,'Kiran',49,'M','SC','T','Darbarnew')");
////
//
//            //Showing group by clause
//            ResultSet rs1=stmt.executeQuery("select cno,max(r_no) from stud2 group by cno");
            ResultSet rs1=stmt.executeQuery("select HotelID from Hotel ORDER BY HotelID DESC LIMIT 1");
            try {
//
                while (rs1.next()) {

//                    System.out.print(rs1.getString(1));
//
                    System.out.print("\t" + rs1.getInt(1));
                  int a = rs1.getInt(1)+1;
                    System.out.println(a);
//                    System.out.println("\t"+rs1.getString(3));
//                }
//
                }
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}


