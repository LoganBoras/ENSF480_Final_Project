package TRA.Domain;

import Database.DatabaseManager;

import java.util.ArrayList;

public class TRA {

    private DatabaseManager databaseManager;
    private User user;

    public TRA(DatabaseManager db, User u) {
        databaseManager = db;
        user = u;
    }

    public TRA() {
        databaseManager = new DatabaseManager();
        databaseManager.initialize(null);
    }

    public ArrayList<Movie> sendMovieList() {
        return databaseManager.getMovies();
    }

    public ArrayList<Theatre> sendTheatreList() {
        return databaseManager.getTheatres();
    }

    public ArrayList<Showing> sendAllShowings() {
        return databaseManager.getShowings();
    }

    public ArrayList<Showing> getShowings(Movie m, Theatre t) {
        return databaseManager.getShowingList(m, t);
    }

    public SeatMap getSeatMap(Showing s) {
        return databaseManager.getSeatMap(s.getSeatMap().getSeatMapID());
    }

    public void updateSeatVacancy(Seat s, boolean vacant) {
        s.setVacant(vacant);
        databaseManager.updateSeatStatus(s.getSeatNumber(), s.getSeatMapID(), vacant);
    }

    public ArrayList<Seat> sendSeatList() {
        return databaseManager.getSeats();
    }

    public ArrayList<SeatMap> sendAllSeatMaps() {
        return databaseManager.getSeatMaps();
    }
}
