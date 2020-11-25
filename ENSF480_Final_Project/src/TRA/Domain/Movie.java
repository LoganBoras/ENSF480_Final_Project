package TRA.Domain;

public class Movie {
    private String movieTitle;
    private String dateReleased;
    private int movieLength;
    private String genre;

    public Movie(String movieTitle, String dateReleased, int movieLength, String genre) {
        this.movieTitle = movieTitle;
        this.dateReleased = dateReleased;
        this.movieLength = movieLength;
        this.genre = genre;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getDateReleased() {
        return dateReleased;
    }

    public void setDateReleased(String dateReleased) {
        this.dateReleased = dateReleased;
    }

    public int getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(int movieLength) {
        this.movieLength = movieLength;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
