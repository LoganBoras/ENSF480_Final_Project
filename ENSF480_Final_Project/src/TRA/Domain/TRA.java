package TRA.Domain;

import Database.DatabaseManager;
import TRA.Presentation.HomeScreen;
import FinancialInstitute.FinancialInstitute;
import FinancialInstitute.FinancialInstituteManager;

import java.util.ArrayList;

import java.util.ArrayList;

public class TRA {

    private DatabaseManager databaseManager;
    private FinancialInstitute financialInstitute;
    private User user;
    private RegisteredUser registeredUser;
    private RegularUser regularUser;

    public TRA(DatabaseManager db, User u) {
        databaseManager = db;
        user = u;
        this.financialInstitute = new FinancialInstituteManager();
    }

    public TRA() {
        databaseManager = new DatabaseManager();
        databaseManager.initialize(null);
        registeredUser = new RegisteredUser();
        this.financialInstitute = new FinancialInstituteManager();
    }

    public void sendPaymentToFinancialInstituteForProcessing(Payment payment) {
        this.financialInstitute.processPayment(payment);
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

    public void updateSeatVacancy(SeatMap sm, Seat s, boolean vacant) {
        s.setVacant(vacant);
        //databaseManager.updateSeatStatus(s.getSeatNumber(), s.getSeatMapID(), vacant);
        databaseManager.updateSeat(sm, s);
    }

    /*public ArrayList<Seat> sendSeatList() {
        return databaseManager.getSeats();
    }

    public ArrayList<SeatMap> sendAllSeatMaps() {
        return databaseManager.getSeatMaps();
    }*/

    public static ArrayList<Movie> upcomingMoviesList() {
        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Cats", "yesterday", 17, "horror"));
        return movieList;
    }

    public void registerUser(int cardNumber, String expiryDate, int csv, String emailAddress, String firstName, String lastName, String password) {
        boolean validEmail = databaseManager.checkEmailAvailability(emailAddress);
        if(validEmail) {
            registeredUser.register(-1, cardNumber, expiryDate, csv, emailAddress, firstName, lastName, password);
            int accountID = databaseManager.registerUser(registeredUser);
            registeredUser.getUserAccount().setAccountID(accountID);
        }
        else {
            System.out.println("Another user has registered with that email. Please try again.");
        }
    }

    public void loginUser(String email, String password) {
        boolean validLogin = databaseManager.validateLogin(email, password);
        if(validLogin) {
            registeredUser = databaseManager.getUser(email, password);
        }
        else {
            System.out.println("Invalid login. Please try again.");
        }
    }

    public void storeTicketOrder(ArrayList<Ticket> tickets, String email) {
        databaseManager.createOrder(tickets, email);
    }

    public FinancialInstitute getFinancialInstitute() {
        return financialInstitute;
    }
}