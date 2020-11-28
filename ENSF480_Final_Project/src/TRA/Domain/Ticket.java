package TRA.Domain;

public class Ticket {
    private Movie movie;
    private Theatre theatre;
    private Seat seat;
    private double cost;
    private int ticketID;

    public Ticket(Movie movie, Theatre theatre, Seat seat, double cost, int ticketID) {
        this.movie = movie;
        this.theatre = theatre;
        this.seat = seat;
        this.cost = cost;
        this.ticketID = ticketID;
    }

    public void udpateTicket(Movie m, Theatre t, Seat s, double c) {
        movie = m;
        theatre = t;
        seat = s;
        cost = c;
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

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    @Override
    public String toString() {
        return "Ticket:\n" +
                "\tMovie: " + movie.getMovieTitle() + "\n" +
                "\tTheatre: " + theatre.getTheatreName() + "\n" +
                "\tSeat: " + seat.getSeatNumber() + "\n" +
                "\tTicket ID: " + ticketID;
    }
}
