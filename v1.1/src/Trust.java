import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Trust {
    Statement stmt;
    public void chooseOption(Statement stmt){
        this.stmt = stmt;
        int opt;
        while(true){
            System.out.println("Trust Menu:\n\t1. Check new added list and apply.\n\t2. Confirm delivery of food from delivery person.\n\t3. Exit\nChoose:");
            Scanner sc = new Scanner(System.in);
            opt = sc.nextInt();

            if (opt>3||opt<1){
                if (opt==3){
                    System.exit(0);
                }
                System.out.println("Invalid input try again !!!");
            }else {
                switch (opt){
                    case 1:
                        applyForFood();
                        break;
                    case 2:
                        confirmsDelivery();
                        break;

                }
            }

        }
    }

    private void confirmsDelivery() {
    }

    private void applyForFood() {
    }

}
