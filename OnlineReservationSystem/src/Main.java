import java.util.Scanner;

import model.Reservation;
import service.CancellationService;
import service.LoginService;
import service.ReservationService;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LoginService loginService =
                new LoginService();

        System.out.println("===== LOGIN FORM =====");

        System.out.print("Login ID : ");
        String id = sc.nextLine();

        System.out.print("Password : ");
        String password = sc.nextLine();

        if(!loginService.login(id, password)) {

            System.out.println("Invalid Login");
            return;
        }

        ReservationService reservationService =
                new ReservationService();

        CancellationService cancellationService =
                new CancellationService();

        while(true) {

            System.out.println("\n1. Reservation Form");
            System.out.println("2. Cancellation Form");
            System.out.println("3. Exit");

            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1:

                    System.out.print("Passenger Name : ");
                    String name = sc.nextLine();

                    System.out.print("Train Number : ");
                    int trainNumber = sc.nextInt();
                    sc.nextLine();

                    String trainName;

                    if(trainNumber == 101)
                        trainName = "Rajdhani Express";
                    else if(trainNumber == 102)
                        trainName = "Shatabdi Express";
                    else
                        trainName = "Unknown Train";

                    System.out.println(
                            "Train Name : "
                                    + trainName);

                    System.out.print("Class Type : ");
                    String classType =
                            sc.nextLine();

                    System.out.print(
                            "Date Of Journey : ");

                    String date =
                            sc.nextLine();

                    System.out.print("From : ");
                    String from =
                            sc.nextLine();

                    System.out.print("Destination : ");
                    String destination =
                            sc.nextLine();

                    String pnr =
                            reservationService
                                    .reserveTicket(
                                            name,
                                            trainNumber,
                                            classType,
                                            date,
                                            from,
                                            destination);

                    System.out.println(
                            "Reservation Successful");

                    System.out.println(
                            "PNR Number : "
                                    + pnr);

                    break;

                case 2:

                    System.out.print(
                            "Enter PNR Number : ");

                    String pnrNumber =
                            sc.nextLine();

                    Reservation reservation =
                            cancellationService
                                    .findReservation(
                                            pnrNumber);

                    if(reservation == null) {

                        System.out.println(
                                "PNR Not Found");
                    }
                    else {

                        System.out.println(
                                reservation);

                        System.out.print(
                                "\nPress Y To Confirm Cancellation : ");

                        String confirm =
                                sc.nextLine();

                        if(confirm.equalsIgnoreCase("Y")) {

                            cancellationService
                                    .cancelTicket(
                                            pnrNumber);

                            System.out.println(
                                    "Ticket Cancelled Successfully");
                        }
                    }

                    break;

                case 3:
                    System.exit(0);

                default:
                    System.out.println(
                            "Invalid Choice");
            }
        }
    }
}