package Raildatabase;

import java.util.Scanner;
public class ManuOperation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RailwayBookingData rbd = new RailwayBookingData();

        while (true) {
            System.out.println("Welcome to Railway Booking Information:");
            System.out.println("1. Insert");
            System.out.println("2. Display");
            System.out.println("3. Display All");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("6. Exit");
            System.out.print("Enter Your Option: ");

            int opt = sc.nextInt(); 

            switch (opt) {
                case 1:
                    rbd.RailwayDataInsert();
                    break;
                case 2:
                    rbd.RailwayDataDisplay();
                    break;
                case 3:
                    rbd.RailwayDataDisplayAll();
                    break;
                case 4:
                    rbd.RailwayDataUpdate();
                    break;
                case 5:
                    rbd.RailwayDataDelete();
                    break;
                case 6:
                    System.out.println("Exit From Menu!");
                   
                    return; 
                default:
                    System.out.println("Option Not Founf");
            }

            System.out.print("Do you want to do more? (Y/N): ");
            char more = sc.next().charAt(0);
            if (more == 'N' || more == 'n') {
                System.out.println("Exit From Menu.");
                return; 
            }
        }
    }
}
