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

    public ArrayList<Movie> sendMovieList() {
        return databaseManager.getMovies();
    }

    public ArrayList<Theatre> sendTheatreList() {
        return databaseManager.getTheatres();
    }
}
