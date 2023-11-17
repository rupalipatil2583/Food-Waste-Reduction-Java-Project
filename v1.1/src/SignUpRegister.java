import java.sql.*;
import java.util.Scanner;

public class SignUpRegister {
    Connection conn;
    void chooseOption(Connection conn) throws SQLException {
        this.conn = conn;
        int opt,entity;
        String EntityName = new String("");

        while(true){
            System.out.println("Sign Up / Registration Menu:\n\t1. Sign Up\n\t2. Register\n\t3. Exit\nChoose:");
            Scanner sc = new Scanner(System.in);
            opt = sc.nextInt();

            if (opt>2||opt<1){
                if (opt==3){
                    System.exit(0);
                }
                System.out.println("Invalid input try again !!!");
            }else {
                while(true){
                    System.out.println("Select the entity:\n\t1. Hotel Admin\n\t2. Trust Admin\n\t3. Delivery service\n\t4. Exit\nChoose: ");
                    entity = sc.nextInt();
                    if (entity>3||entity<1) {
                        if (entity == 4) {
                            System.exit(0);
                        }
                        System.out.println("Invalid input try again !!!");
                    }
                    else{
                        EntityName = (opt==1)?"Hotel":(opt==2)?"Trust":"Dilevary";
                        break;
                    }
                }

                break;
            }

        }
        switch (opt){
            case 1:
                signUp(EntityName);
                break;
            case 2:
                registration(EntityName);
               break;
        }
    }
    void signUp(String EntityName){

    }
    void registration(String EntityName) {

        int ID;
        String UserName = new String(" ");
        String mail = new String(" ");
        String password = new String(" ");
        String Address = new String(" ");
        String city = new String(" ");
        long contact;


        System.out.println("Welcome to new registration.");
        System.out.println("Enter username");


//      Fetiching last hotel id and incrementing it by 1 to add new entry.
        try {
            Statement stmt = conn.createStatement();
            ResultSet R = stmt.executeQuery("select HotelID from Hotel ORDER BY HotelID DESC LIMIT 1");
            try {
                while (R.next()) {
                    ID = R.getInt(1) + 1;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
