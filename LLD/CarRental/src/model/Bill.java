package model;

public class Bill {
    Reservation reservation;
    double totalAmount;
    boolean isPaid;

    public Bill(Reservation reservation) {
        this.reservation = reservation;
        this.totalAmount = computeBillAmount();
        isPaid = false;
    }

    private double computeBillAmount() {
        return 100.0;
    }
}
