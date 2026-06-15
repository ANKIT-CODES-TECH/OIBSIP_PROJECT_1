package service;

import data.ReservationDatabase;
import model.Reservation;

public class CancellationService {

    public Reservation findReservation(String pnr) {

        return ReservationDatabase
                .reservations
                .get(pnr);
    }

    public boolean cancelTicket(String pnr) {

        if(ReservationDatabase
                .reservations
                .containsKey(pnr)) {

            ReservationDatabase
                    .reservations
                    .remove(pnr);

            return true;
        }

        return false;
    }
}