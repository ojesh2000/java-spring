package model;

import java.util.Date;

public class Reservation {
    int reservationId;
    User user;
    Vehicle vehicle;
    Date date;
    Date bookedFrom;
    Date bookedTo;
    Long fromTimeStamp;
    Long toTimeStamp;
    Location pickupLocation;
    Location dropLocation;
    ReservationType reservationType;
    ReservationStatus reservationStatus;
    Location visitLocation;

    public int createReservation(User user, Vehicle vehicle){
        //gen new reservationId
        reservationId = 123;
        this.user = user;
        this.vehicle = vehicle;
        reservationType = ReservationType.DAILY;
        reservationStatus = ReservationStatus.SCHEDULED;
        return reservationId;
    }
}
