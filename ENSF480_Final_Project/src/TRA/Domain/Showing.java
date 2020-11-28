package TRA.Domain;

import java.util.ArrayList;

public class Showing {
    private String showtime;
    private Movie movie;
    private Theatre theatre;
    private SeatMap seatMap;
    private int showingID;


    public Showing(int showingID, Movie movie, Theatre theatre, SeatMap seatMap, String st) {
        this.showingID = showingID;
        this.showtime = st;
        this.movie = movie;
        this.theatre = theatre;
        this.seatMap = seatMap;
    }

    public String getShowtime() {
        return showtime;
    }

    public void setShowtime(String showtime) {
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
