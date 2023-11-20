
import java.sql.Statement;
import java.util.Scanner;

public class Hotel {
    Statement stmt;
    public void chooseOption(Statement stmt){
        this.stmt = stmt;
        int opt;
        while(true){
            System.out.println("Hotel Menu:\n\t1. Add new food record\n\t2. Check pending confirmation entries of trusts.\n\t3. Check pending confirmation entries of delivery persons.\n\t4. Exit\nChoose:");
            Scanner sc = new Scanner(System.in);
            opt = sc.nextInt();

            if (opt>4||opt<1){
                if (opt==4){
                    System.exit(0);
                }
                System.out.println("Invalid input try again !!!");
            }else {
                switch (opt){
                    case 1:
                        addNewRecord();
                        break;
                    case 2:
                        trustRequestPendingConfirmToHotel();
                        break;
                    case 3:
                        deliveryRequestPendingConfirmToHotel();
                        break;
                }
            }

        }
    }


    private void addNewRecord() {
    }

    private void trustRequestPendingConfirmToHotel() {
    }

    private void deliveryRequestPendingConfirmToHotel() {
    }

}
