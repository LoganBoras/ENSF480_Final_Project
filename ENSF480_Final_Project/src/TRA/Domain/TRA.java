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

    public ArrayList<Showing> getShowings(String m, String t) {
        return databaseManager.getShowingList(m, t);
    }

    public SeatMap getSeatMap(String movieTitle, String theatreName, String showtime) {
        return databaseManager.getSeatMap(movieTitle, theatreName, showtime);
    }

    public void updateSeatVacancy(SeatMap sm, Seat s, boolean vacant) {
        s.setVacant(vacant);
        //databaseManager.updateSeatStatus(s.getSeatNumber(), s.getSeatMapID(), vacant);
        databaseManager.updateSeat(sm, s, vacant);
    }
    
    public static ArrayList<Movie> upcomingMoviesList() {
        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Cats", "yesterday", 17, "horror"));
        return movieList;
    }

    public void registerUser(String cardNumber, String expiryDate, int csv, String emailAddress, String firstName, String lastName, String password) {
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

    public void storeTicketOrder(ArrayList<Ticket> ticket, String email) {
        databaseManager.createOrder(ticket, email);
    }

    public ArrayList<Ticket> getOrder(String email) {
        return databaseManager.getOrder(email);
    }

    public FinancialInstitute getFinancialInstitute() {
        return financialInstitute;
    }

    public ArrayList<String> getEmails() {
        return databaseManager.getEmails();
    }

    public int getTicketID(Showing s, Ticket t) {
        return databaseManager.getTicketID(s, t);
    }

    public int cancelTicket(int ticketID) {
        return databaseManager.cancelTicket(ticketID);
    }
    
    public boolean emailExistsInOrders(String email) {
        return databaseManager.emailExistsInOrders(email);
    }

    public void checkOrderStatus(int orderID) {
        databaseManager.checkOrderStatus(orderID);
    }
}