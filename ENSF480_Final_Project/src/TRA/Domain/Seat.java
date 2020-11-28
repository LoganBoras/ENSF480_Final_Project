package TRA.Domain;

public class Seat {
    private boolean vacant;
    private int seatNumber;
    private int seatMapID;

    public Seat(int seatMapID, int seatNumber, boolean vacant) {
        this.vacant = vacant;
        this.seatNumber = seatNumber;
        this.seatMapID = seatMapID;
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

    public int getSeatMapID() {
        return seatMapID;
    }

    public void setSeatMapID(int seatMapID) {
        this.seatMapID = seatMapID;
    }
}
