package TRA.Control;

import java.util.ArrayList;

import javax.swing.JFrame;

import TRA.Domain.Movie;
import TRA.Domain.SeatMap;
import TRA.Domain.Showing;
import TRA.Domain.Theatre;
import TRA.Presentation.*;

public class OrderSelectionController extends Subject{
	
	private OrderSelectionController itself;
	private JFrame frame;
	
	private ArrayList<String> data;	//1st index: chosen movie, 2nd index: chosen theatre, 3rd index: chosen showtime, 4th index: chosen seat.
	private ArrayList<Movie> movies;
	private ArrayList<Theatre> theatres;
	private ArrayList<Showing> showTimes;
	private SeatMap seats;
	
	public OrderSelectionController(JFrame frame, Subject subject) {
		this.frame = frame;
		setID(2);	//ID for OrderSelection Frame;
		data = new ArrayList<String>();
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
		
		return;
		
	}
	
	private void runMovieSelection() {
		int prevID;
		movies = new ArrayList<Movie>();
		movies.add(new Movie("title1", "1",1,"genre1"));
		movies.add(new Movie("title2", "1",1,"genre1"));
		movies.add(new Movie("title3", "1",1,"genre1"));
		Screen Screen = new MovieSelectionScreen(frame, itself, movies);
		Screen.displayScreen();
		
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
		theatres = new ArrayList<Theatre>();
		theatres.add(new Theatre("theatre1"));
		theatres.add(new Theatre("theatre2"));
		theatres.add(new Theatre("theatre3"));
		
		Screen Screen = new TheatreSelectionScreen(frame, itself, theatres);
		Screen.displayScreen();
		
		while(getID() == prevID) {
			if(i == 0)
				System.out.println("waiting for TheatreSelectionScreen to finish...");
			i++;
		}
	}
	
	private void runShowTimeSelection() {
		int prevID = getID();
		int i = 0;
		ArrayList<Showing> showTimes = new ArrayList<Showing>();
		showTimes.add(new Showing(12, movies.get(1), theatres.get(1)));
		showTimes.add(new Showing(13, movies.get(1), theatres.get(1)));
		showTimes.add(new Showing(14, movies.get(1), theatres.get(1)));
		
		Screen Screen = new ShowTimeSelectionScreen(frame, itself, showTimes);
		Screen.displayScreen();
		
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
		seats = new SeatMap();
		
		Screen Screen = new SeatSelectionScreen(frame, itself, seats);
		Screen.displayScreen();
		
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
