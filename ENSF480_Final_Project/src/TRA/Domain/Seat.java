package TRA.Domain;

public class Seat {
    private boolean vacant;
    private int seatNumber;

    public Seat(boolean vacant, int seatNumber) {
        this.vacant = vacant;
        this.seatNumber = seatNumber;
    }

    public boolean isVacant() {
        return vacant;
    }

    public void setVacant(boolean vacant) {
        this.vacant = vacant;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
