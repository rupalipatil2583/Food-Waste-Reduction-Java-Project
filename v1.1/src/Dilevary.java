import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Dilevary {
    Statement stmt;
    public void chooseOption(Statement stmt){
        this.stmt = stmt;
        int opt;
        while(true){
            System.out.println("Delivery Menu:\n\t1. Check new added list and apply.\n\t2. Check applied delivery confirmation.\n\t3. Exit\nChoose:");
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
                        applyForDelivery();
                        break;
                    case 2:
                        pendingRequestConfirmationFromHotel();
                        break;

                }
            }

        }
    }

    private void applyForDelivery() {
    }

    private void pendingRequestConfirmationFromHotel() {
    }

}
