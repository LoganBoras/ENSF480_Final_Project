package TRA.Domain;

public class Showing {
	private int showingID;
    private int showtime;
    private Movie movie;
    private Theatre theatre;
    private SeatMap seatMap;

    public Showing(int showingID, int showtime, Movie movie, Theatre theatre, SeatMap seatMap) {
        this.setShowingID(showingID);
    	this.showtime = showtime;
        this.movie = movie;
        this.theatre = theatre;
        this.seatMap = seatMap;
    }

    public int getShowtime() {
        return showtime;
    }

    public void setShowtime(int showtime) {
        this.showtime = showtime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public SeatMap getSeatMap() {
        return seatMap;
    }

    public void setSeatMap(SeatMap seatMap) {
        this.seatMap = seatMap;
    }

	public int getShowingID() {
		return showingID;
	}

	public void setShowingID(int showingID) {
		this.showingID = showingID;
	}
}
