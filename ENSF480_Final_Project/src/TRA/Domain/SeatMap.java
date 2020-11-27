package TRA.Domain;

import java.util.ArrayList;

public class SeatMap {

    private ArrayList<Seat> seats;
    private int seatMapID;
    private int reservedSeatCount;
    private int numberOfRows;
    private int numberOfAvailableSeats;

    public SeatMap(ArrayList<Seat> seats, int seatMapID, int reservedSeatCount, int numberOfRows, int numberOfAvailableSeats) {
        this.seats = seats;
        this.seatMapID = seatMapID;
        this.reservedSeatCount = reservedSeatCount;
        this.numberOfRows = numberOfRows;
        this.numberOfAvailableSeats = numberOfAvailableSeats;
    }

    public void updateSeatStatus(Seat updateSeat) {
        seats.get(updateSeat.getSeatNumber() - 1).setVacant(!updateSeat.isVacant());
    }

    public void updateReservedSeatCount(int reservedSeatNum) {
        reservedSeatCount = reservedSeatNum;
    }

    public void updateAvailableSeats(int availableSeats) {
        numberOfAvailableSeats = availableSeats;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public int getReservedSeatCount() {
        return reservedSeatCount;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfAvailableSeats() {
        return numberOfAvailableSeats;
    }

	public int getSeatMapID() {
		return seatMapID;
	}

	public void setSeatMapID(int seatMapID) {
		this.seatMapID = seatMapID;
	}
}
