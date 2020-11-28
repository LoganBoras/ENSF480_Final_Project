package TRA.Domain;

import Database.DatabaseManager;

import java.util.ArrayList;

import java.util.ArrayList;

public class TRA {

    private DatabaseManager databaseManager;
    private User user;

    public TRA() {
        //TODO implement default constructor
    }

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

    //TODO - this function should be actually implemented so it returns every
    //movie in the database - right now it is just a dummy function
    /**
     * Returns array list containing upcoming movies
     * @return ArrayList<Movie> - upcoming movies
     */
    public static ArrayList<Movie> upcomingMoviesList() {
        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Cats", "yesterday", 17, "horror"));
        return movieList;
    }

}
