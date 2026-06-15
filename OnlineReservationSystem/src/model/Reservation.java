package model;

public class Reservation {

    private String pnrNumber;
    private String passengerName;
    private int trainNumber;
    private String trainName;
    private String classType;
    private String journeyDate;
    private String fromPlace;
    private String destination;

    public Reservation(String pnrNumber,
                       String passengerName,
                       int trainNumber,
                       String trainName,
                       String classType,
                       String journeyDate,
                       String fromPlace,
                       String destination) {

        this.pnrNumber = pnrNumber;
        this.passengerName = passengerName;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.classType = classType;
        this.journeyDate = journeyDate;
        this.fromPlace = fromPlace;
        this.destination = destination;
    }

    public String getPnrNumber() {
        return pnrNumber;
    }

    @Override
    public String toString() {
        return "PNR Number : " + pnrNumber +
                "\nPassenger Name : " + passengerName +
                "\nTrain Number : " + trainNumber +
                "\nTrain Name : " + trainName +
                "\nClass Type : " + classType +
                "\nJourney Date : " + journeyDate +
                "\nFrom : " + fromPlace +
                "\nTo : " + destination;
    }
}