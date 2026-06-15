package service;

import data.ReservationDatabase;
import model.Reservation;

public class ReservationService {

    public String reserveTicket(String passengerName,
                                int trainNumber,
                                String classType,
                                String journeyDate,
                                String fromPlace,
                                String destination) {

        String trainName = getTrainName(trainNumber);

        String pnr =
                "PNR" + (int)(Math.random() * 100000);

        Reservation reservation =
                new Reservation(
                        pnr,
                        passengerName,
                        trainNumber,
                        trainName,
                        classType,
                        journeyDate,
                        fromPlace,
                        destination);

        ReservationDatabase.reservations.put(
                pnr,
                reservation);

        return pnr;
    }

    private String getTrainName(int trainNumber) {

        if(trainNumber == 101) {
            return "Rajdhani Express";
        }
        else if(trainNumber == 102) {
            return "Shatabdi Express";
        }

        return "Unknown Train";
    }
}