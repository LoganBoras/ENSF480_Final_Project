package TRA.Control;

import java.util.ArrayList;

import javax.swing.JFrame;

import TRA.Domain.*;
import TRA.Presentation.*;

public class OrderSelectionController extends Subject{
	
	private OrderSelectionController itself;
	private JFrame frame;
	
	private ArrayList<String> data;	//1st index: chosen movie, 2nd index: chosen theatre, 3rd index: chosen showtimeID, 4th index: chosen seat.
	private ArrayList<Movie> movies;
	private ArrayList<Theatre> theatres;
	private ArrayList<Showing> showTimes;
	private SeatMap seats;
	private TRA tra;
	private Ticket ticket;
	private TicketOrder order;
	
	
	public OrderSelectionController(JFrame frame, Subject subject) {
		this.frame = frame;
		setID(2);	//ID for OrderSelection Frame;
		data = new ArrayList<String>();
		tra = new TRA();
	}
	
	public void runOrderSelection(){
		
		runMovieSelection();
		System.out.println("MovieSelection Exited");
		
		runTheatreSelection();
		System.out.println("TheatreSelection Exited.");
		
		runShowTimeSelection();
		System.out.println("ShowTimeSelection Exited");
		
		runSeatSelection();
		System.out.println("SeatSelection Exited");
		
		System.out.println("USER SELECTED THE FOLLOWING: ");
		for(int j = 0; j < data.size(); j++) {
			System.out.println(data.get(j));
		}
		
		buildOrder();
		
		runPayment();

		System.out.println("Payment Process complete.");
		
		return;
		
	}
	
	private void runPayment() {
		// TODO Auto-generated method stub
			
		OrderPaymentController orderPayment = new OrderPaymentController(this.frame, itself, this.order);
		orderPayment.runOrderPayment();
		
	}

	private void buildOrder() {
		// TODO Auto-generated method stub
		Showing showing = null;
		
		for(int i = 0; i < showTimes.size(); i++) {
			if(Integer.parseInt(data.get(2)) == showTimes.get(i).getShowingID()) {
				showing = showTimes.get(i);
				break;
			}
		}
		
		Seat seat = showing.getSeatMap().getSeats().get(Integer.parseInt(data.get(3)));
		
		ticket = new Ticket(showing.getMovie(), showing.getTheatre(), seat, 12 , 1, showing.getShowtime());
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		tickets.add(ticket);
		
		TicketOrder order = new TicketOrder(tickets);
	
	}

	private void runMovieSelection() {
		int prevID;
		movies = tra.sendMovieList();
		Screen Screen = new MovieSelectionScreen(frame, itself, movies);
		Screen.buildScreen();

		prevID = getID();
		int i = 0;
		while(getID() == prevID) {
			if(i == 0) 
				System.out.println("waiting for MovieSelectionScreen to finish...");
			i++;
			}
	}
	
	private void runTheatreSelection() {
		int prevID = getID();
		int i = 0;
		theatres = tra.sendTheatreList();
		
		Screen Screen = new TheatreSelectionScreen(frame, itself, theatres);
		Screen.buildScreen();
		
		while(getID() == prevID) {
			if(i == 0)
				System.out.println("waiting for TheatreSelectionScreen to finish...");
			i++;
		}
	}
	
	private void runShowTimeSelection() {
		int prevID = getID();
		int i = 0;
		ArrayList<Showing> showTimes = tra.getShowings(data.get(0), data.get(1));
		
		Screen Screen = new ShowTimeSelectionScreen(frame, itself, showTimes);
		Screen.buildScreen();
		
		while(getID() == prevID) {
			if(i == 0)
				System.out.println("waiting for ShowTimeSelectionScreen to finish...");
			i++;
		}
	}

	private void runSeatSelection() {
		// TODO Auto-generated method stub
		int prevID = getID();
		int i = 0;
		seats = tra.getSeatMap(data.get(0), data.get(1), data.get(2));
		
		Screen Screen = new SeatSelectionScreen(frame, itself, seats);
		Screen.buildScreen();
		
		while(getID() == prevID) {
			if(i == 0)
				System.out.println("waiting for SeatSelectionScreen to finish...");
			i++;
		}
	}
	
	
	@Override
	public void addData(String data) {
		// TODO Auto-generated method stub
		this.data.add(data);
	}
	
	public void setItself(OrderSelectionController itself ) {
		this.itself = itself;
	}
}
