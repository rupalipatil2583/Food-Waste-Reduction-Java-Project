import java.sql.*;
import java.util.Scanner;
import java.util.regex.*;

public class SignUpRegister {
    Statement stmt;

    SignUpRegister(Statement stmt){
        this.stmt = stmt;
    }
    Scanner sc = new Scanner(System.in);
    void chooseOption() throws SQLException {

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
                        EntityName = (entity==1)?"Hotel":(entity==2)?"Trust":"Dilevary";
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
        String UserName,password;
        System.out.println("Welcome to log in page.");
        outerloop:
        while(true) {
            System.out.print("Enter username: ");
            UserName = sc.nextLine();
            if (UserName.isEmpty()){
                System.out.println("Enter valid username again." );
                continue;
            }
            System.out.print("Enter password: ");
            password = sc.nextLine();

            try {
                ResultSet R=stmt.executeQuery("SELECT "+EntityName+"Password FROM "+EntityName+" where "+EntityName+"UserName=\""+UserName+"\"");
                try {
                    while (R.next()) {
                        String passwordT= R.getString(1);
                        if (password.equals(passwordT)){
                            System.out.println("Logged in successfully.");
                            break outerloop;
                        }
                    }
                    System.out.println("Invalid username or password.\nEnter valid username and password again.");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Directing to corresponding pages.");
        switch (EntityName){
            case "Hotel":
                Hotel H = new Hotel();
                H.chooseOption(stmt);
                break;
            case "Trust":
                Trust T = new Trust();
                T.chooseOption(stmt);
                break;
            case "Dilevary":
                Dilevary D = new Dilevary();
                D.chooseOption(stmt);
                break;
        }
    }
    void registration(String EntityName) throws SQLException {

        int ID = 1;
        String UserName,Name,mail,password,Address,city,contactT;
        long contact;


        System.out.println("Welcome to new registration.");
        while(true){
            System.out.print("Enter name of "+EntityName+": ");
            Name = sc.nextLine();
            if (Name.isEmpty()){
                System.out.println("Enter valid username again." );
            }else {
                break;
            }
        }
        while(true){
            System.out.print("Enter username: ");
            UserName = sc.nextLine();
            if (UserName.isEmpty()){
                System.out.println("Enter valid username again." );
            }else {
                break;
            }
        }
        while(true) {
            System.out.print("Enter mail address: ");
            mail = sc.nextLine();
            String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(mail);

            if (!matcher.matches()) {
                System.out.println("Enter valid mail address again.");
            } else {
                break;
            }
        }
        while(true) {
            System.out.print("Enter password: ");
            password = sc.nextLine();
            String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(password);

            if (!matcher.matches()) {
                System.out.println("Enter valid password again.");
            } else {
                break;
            }
        }
        while(true){
            System.out.print("Enter address: ");
            Address = sc.nextLine();
            if (Address.isEmpty()){
                System.out.println("Enter valid address again." );
            }else {
                break;
            }
        }
        while(true){
            System.out.print("Enter city: ");
            city = sc.nextLine();
            if (city.isEmpty()){
                System.out.println("Enter valid city again." );
            }else {
                break;
            }
        }
        while(true){
            System.out.print("Enter contact number : ");
            contactT = sc.nextLine();
            String regex = "(0/91)?[6-9][0-9]{9}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(contactT);
            if (!matcher.matches()){
                System.out.println("Enter valid contact number again." );
            }else {
                contact = Long.parseLong(contactT);
                break;
            }
        }

//      Fetiching last hotel id and incrementing it by 1 to add new entry.
        try {

            ResultSet R = stmt.executeQuery("select "+EntityName+"ID from "+EntityName+" ORDER BY "+EntityName+"ID DESC LIMIT 1");
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

        //add data in table
        stmt.executeUpdate("insert into "+EntityName+" values("+ID+",'"+Name+"','"+UserName+"','"+mail+"','"+password+"','"+Address+"','"+city+"',"+contact+");");

        System.out.println("You registation is successfully completed.\nYou can log in now.");
        signUp(EntityName);
    }
}
