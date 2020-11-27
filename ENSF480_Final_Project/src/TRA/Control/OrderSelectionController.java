package TRA.Control;

import java.util.ArrayList;

import javax.swing.JFrame;

import TRA.Domain.Movie;
import TRA.Domain.Showing;
import TRA.Domain.Theatre;
import TRA.Presentation.*;

public class OrderSelectionController extends Subject{
	
	private JFrame frame;
	
	private String data;	//
	
	
	
	public OrderSelectionController() {
		frame = new JFrame("Main Window");
		setID(1);
	}
	
	public static void main(String args []) {
		
		OrderSelectionController test = new OrderSelectionController();
		
		int prevID;
		
		Screen Screen = new HomeScreen(test.frame, test);
		
		//HomeScreen Screen = new HomeScreen(test.frame, test);
		Screen.displayScreen();
		
		//while(Screen.ArrayList<E>ion() == -1) {}
		
		while(test.getID() == 1) {System.out.println("waiting for homepage");}
		
		
		prevID = Screen.screenID;
		
		System.out.println("Homepage exited.");
		
		ArrayList<Movie> movies = new ArrayList<Movie>();
		movies.add(new Movie("title1", "1",1,"genre1"));
		movies.add(new Movie("title2", "1",1,"genre1"));
		movies.add(new Movie("title3", "1",1,"genre1"));
		
		Screen selectMovie = new MovieSelectionScreen(test.frame, test, movies);
		
		Screen = new MovieSelectionScreen(test.frame, test, movies);
		Screen.displayScreen();
		//System.out.println("Returned value from screen : " + Screen.getSelection());
		
		while(test.getID() == prevID) {
			System.out.println("waiting for MovieSelection to finish...");
		}
		
		System.out.println("MovieSelection Exited. ");
		prevID = test.getID();
		
		ArrayList<Theatre> theatres = new ArrayList<Theatre>();
		theatres.add(new Theatre("theatre1"));
		theatres.add(new Theatre("theatre2"));
		theatres.add(new Theatre("theatre3"));
		
		Screen = new TheatreSelectionScreen(test.frame, test, theatres);
		Screen.displayScreen();
		
		while(test.getID() == prevID) {
			System.out.println("waiting for TheatreSelection to finish...");
		}
		
		System.out.println("TheatreSelection Exited.");
		
		ArrayList<Showing> showTimes = new ArrayList<Showing>();
		showTimes.add(new Showing(12, movies.get(1), theatres.get(1)));
		showTimes.add(new Showing(13, movies.get(1), theatres.get(1)));
		showTimes.add(new Showing(14, movies.get(1), theatres.get(1)));
		
		Screen = new ShowTimeSelectionScreen(test.frame, test, showTimes);
		Screen.displayScreen();
		
		
	}

	@Override
	public void setData(String data) {
		// TODO Auto-generated method stub
		this.data = data;
	}
}
