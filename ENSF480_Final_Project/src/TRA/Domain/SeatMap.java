package TRA.Domain;

import java.util.ArrayList;

public class SeatMap {
	
	    private ArrayList<Seat> seats;
	    private int reservedSeatCount;
	    private int numberOfRows;
	    private int numberOfAvailableSeats;
	    private int seatMapID;

	    public SeatMap() {
	    	seats = new ArrayList<Seat>();
	    	this.reservedSeatCount = 0;
	    	this.numberOfAvailableSeats = 7*5;
	    	this.numberOfRows = 5;
	    	this.numberOfAvailableSeats = 7*5;
	    	this.seatMapID = 2;
	    	for(int i = 0; i<numberOfAvailableSeats; i++)
	    		if(i%2 == 0)
	    			seats.add(new Seat(seatMapID, i, true));
	    		else
	    			seats.add(new Seat(seatMapID, i, false));
	    	
	    }
	    
	    public SeatMap(int seatMapID, int reservedSeatCount, int numberOfRows, int numberOfAvailableSeats, ArrayList<Seat> seats) {
	        this.seats = seats;
	        this.reservedSeatCount = reservedSeatCount;
	        this.numberOfRows = numberOfRows;
	        this.numberOfAvailableSeats = numberOfAvailableSeats;
	        this.seatMapID = seatMapID;
	    }

//	    public void updateSeatStatus(Seat updateSeat) {
//	        seats.get(updateSeat.getSeatNumber() - 1).setVacant(!updateSeat.isVacant());
//	    }

	    public void updateReservedSeatCount(int reservedSeatNum) {
	        reservedSeatCount = reservedSeatNum;
	    }

	    public void updateAvailableSeats(int availableSeats) {
	        numberOfAvailableSeats = availableSeats;
	    }

	    public ArrayList<Seat> getSeats() {
	        return this.seats;
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
