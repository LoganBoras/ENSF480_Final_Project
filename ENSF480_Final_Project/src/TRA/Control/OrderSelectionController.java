package TRA.Control;

import java.util.ArrayList;

import javax.swing.JFrame;

import TRA.Domain.*;
import TRA.Presentation.*;

import static java.lang.Integer.parseInt;

public class OrderSelectionController extends Subject{
	
	private OrderSelectionController itself;
	private JFrame frame;
	
	private ArrayList<String> data;	//1st index: chosen movie, 2nd index: movie index, 3rd index: chosen theatre, 4th index: movie index, 5th index: chosen showtime, 6th index: chosen seat, 7th index: chosen seat index.
	private ArrayList<Movie> movies;
	private ArrayList<Theatre> theatres;
	private ArrayList<Showing> showTimes;
	Movie movieSelected;
	Theatre theatreSelected;
	Seat seatSelected;
	Showing showTimeSelected;
	private SeatMap seats;
	private TRA tra;
	
	public OrderSelectionController(JFrame frame, Subject subject) {
		this.frame = frame;
		setID(2);	//ID for OrderSelection Frame;
		data = new ArrayList<String>();
		tra = new TRA();
	}
	
	public void runOrderSelection(){
		
		runMovieSelection();
		System.out.println("MovieSelection Exited");
		movieSelected = movies.get(parseInt(data.get(1)));
		System.out.println(movieSelected.getMovieTitle());
		
		runTheatreSelection();
		System.out.println("TheatreSelection Exited.");
		theatreSelected = theatres.get(parseInt(data.get(3)));
		System.out.println(theatreSelected.getTheatreName());
		
		runShowTimeSelection();
		System.out.println("ShowTimeSelection Exited");
		showTimeSelected = showTimes.get(parseInt(data.get(5)));
		
		runSeatSelection();
		System.out.println("SeatSelection Exited");
		seatSelected = seats.getSeats().get(parseInt(data.get(7)));
		
		System.out.println("USER SELECTED THE FOLLOWING: ");
		for(int j = 0; j < data.size(); j++) {
			System.out.println(data.get(j));
		}
		ArrayList<Ticket> t = new ArrayList<>();
		t.add(new Ticket(movieSelected, theatreSelected, seatSelected, 12, -1, showTimeSelected.getShowtime()));
		tra.storeTicketOrder(t, "email");
		tra.updateSeatVacancy(seats, seatSelected, false);

		return;
		
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
		showTimes = tra.getShowings(data.get(0), data.get(2));
		
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
		seats = tra.getSeatMap(data.get(0), data.get(2), data.get(4));
		
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
