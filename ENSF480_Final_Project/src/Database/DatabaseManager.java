package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import TRA.Domain.Movie;
import TRA.Domain.Seat;
import TRA.Domain.SeatMap;
import TRA.Domain.Showing;
import TRA.Domain.Theatre;

public class DatabaseManager {
	  static Connection connection=null;
		
public static void initialize(String[] args) {
	
	
	try {
	
	// Load the MySQL JDBC driver
	
	String driverName = "com.mysql.jdbc.Driver";
	
	Class.forName(driverName);
	
	
	// Create a connection to the database
	
	String serverName = "localhost";
	
	String schema = "test";
	
	String url = "jdbc:mysql://" + serverName +  "/" + schema;
	
	String username = "root";
	
	String password = "ENSF480TRA";
	
	connection = DriverManager.getConnection(url, username, password);
	
	 
	
	System.out.println("Successfully Connected to the database!");
	
	 
	  } catch (ClassNotFoundException e) {
	
	System.out.println("Could not find the database driver " + e.getMessage());
	  } catch (SQLException e) {
	
	System.out.println("Could not connect to the database " + e.getMessage());
	  }
	
	}
	 
	 public static ArrayList<Movie> getMovies() {
		 try {
			 
			  // Get a result set containing all data from test_table
			 
			  Statement statement = connection.createStatement();
			 
			  ResultSet results = statement.executeQuery("SELECT * FROM Movie");
			 
			  // For each row of the result set ...
			  ArrayList<Movie> movieResults = new ArrayList<Movie>();
			  while (results.next()) {
			 
			 
			  // Get the data from the current row using the column name - column data are in the VARCHAR format
			  String movieTitle = results.getString(0);
			  String dateReleased = results.getString(1);
			  int movieLength = results.getInt(2);
			  String genre = results.getString(3);
			 
			  movieResults.add(new Movie(movieTitle, dateReleased, movieLength, genre));
			
			}
				 return movieResults;
	
			    } catch (SQLException e) {
			 
			  System.out.println("Could not retrieve data from the database " + e.getMessage());
			    }
		return null;
	 }
	 
	 public static ArrayList<Theatre> getTheatres() {
		 try {
			 
			  // Get a result set containing all data from test_table
			 
			  Statement statement = connection.createStatement();
			 
			  ResultSet results = statement.executeQuery("SELECT * FROM Theatre");
			 
			  // For each row of the result set ...
			  ArrayList<Theatre> theatreResults = new ArrayList<Theatre>();
			  while (results.next()) {
			 
			 
			  // Get the data from the current row using the column name - column data are in the VARCHAR format
			  String theatreName = results.getString(0);

			 
			  theatreResults.add(new Theatre(theatreName));
			 
			 
			  }
				 return theatreResults;
	
			    } catch (SQLException e) {
			 
			  System.out.println("Could not retrieve data from the database " + e.getMessage());
			    }
		return null;
	 }
	 
	 public static ArrayList<Showing> getShowings() {
		 try {
			 
			  // Get a result set containing all data from test_table
			 
			  Statement statement = connection.createStatement();
			 
			  ResultSet results = statement.executeQuery("SELECT * FROM Showing");
			 
			  // For each row of the result set ...
			  String data;
			  ArrayList<Showing> showingResults = new ArrayList<Showing>();
			  while (results.next()) {
			 
			 
			  // Get the data from the current row using the column name - column data are in the VARCHAR format
			  int showingID = results.getInt(0);
			  String movieTitle = results.getString(1);
			  String theatreName = results.getString(2);
			  int seatMapID = results.getInt(3);
			  int showTime = results.getInt(3);
			  ResultSet theMovie = statement.executeQuery("SELECT * FROM Movie WHERE movieTitle = " + movieTitle);
			  String dateReleased = theMovie.getString(1);
			  int movieLength = theMovie.getInt(2);
			  String genre = theMovie.getString(3);
			  
			  showingResults.add(new Showing(showingID, showTime, new Movie(movieTitle, dateReleased, movieLength, genre), 
					  new Theatre(theatreName), new SeatMap(getSeats(seatMapID), seatMapID, showTime, showTime, showTime)));
			 
			 
			}
				 return showingResults;
	
			    } catch (SQLException e) {
			 
			  System.out.println("Could not retrieve data from the database " + e.getMessage());
			    }
		return null;
	 }
	 
	 public static ArrayList<Seat> getSeats() {
		 try {
			 
			  // Get a result set containing all data from test_table
			 
			  Statement statement = connection.createStatement();
			 
			  ResultSet results = statement.executeQuery("SELECT * FROM Movie");
			 
			  // For each row of the result set ...
			  String data;
			  ArrayList<Seat> seatResults = new ArrayList<Seat>();
			  while (results.next()) {
			 
			 
			  // Get the data from the current row using the column name - column data are in the VARCHAR format
			  Boolean vacant = results.getBoolean(0);
			  int seatNumber = results.getInt(1);
			 
			  seatResults.add(new Seat(vacant, seatNumber));
			 
			 
			}
				 return seatResults;
	
			    } catch (SQLException e) {
			 
			  System.out.println("Could not retrieve data from the database " + e.getMessage());
			    }
		return null;
	 }
	 
	 public static ArrayList<Seat> getSeats(int seatMapID) {
		 try {
			 
			  // Get a result set containing all data from test_table
			 
			  Statement statement = connection.createStatement();
			 
			  ResultSet results = statement.executeQuery("SELECT * FROM Movie");
			 
			  // For each row of the result set ...
			  String data;
			  ArrayList<Seat> seatResults = new ArrayList<Seat>();
			  while (results.next()) {
			 
			 
			  // Get the data from the current row using the column name - column data are in the VARCHAR format
			  Boolean vacant = results.getBoolean(0);
			  int seatNumber = results.getInt(1);
			 
			  seatResults.add(new Seat(vacant, seatNumber));
			 
			 
			}
				 return seatResults;
	
			    } catch (SQLException e) {
			 
			  System.out.println("Could not retrieve data from the database " + e.getMessage());
			    }
		return null;
	 }
	 
	 public static ArrayList<SeatMap> getSeatMaps() {
		 try {
			 
			  // Get a result set containing all data from test_table
			 
			  Statement statement = connection.createStatement();
			 
			  ResultSet results = statement.executeQuery("SELECT * FROM Movie");
			 
			  // For each row of the result set ...
			  String data;
			  ArrayList<SeatMap> seatMapResults = new ArrayList<SeatMap>();
			  while (results.next()) {
			 
			 
			  // Get the data from the current row using the column name - column data are in the VARCHAR format
			  int seatMapID = results.getInt(0);
			  int reservedSeatCount = results.getInt(1);
			  int numberOfRows = results.getInt(2);
			  int numberOfAvailableSeats = results.getInt(3);
			  
			  seatMapResults.add(new SeatMap(getSeats(seatMapID), seatMapID, reservedSeatCount, numberOfRows, numberOfAvailableSeats));
			 
			 
			}
				 return seatMapResults;
	
			    } catch (SQLException e) {
			 
			  System.out.println("Could not retrieve data from the database " + e.getMessage());
			    }
		return null;
	 }
	 
	 public static Movie getMovie(String movieTitle) {
		 try {
			 
			  // Get a result set containing all data from test_table
			 
			  Statement statement = connection.createStatement();
			 
			  ResultSet results = statement.executeQuery("SELECT * FROM Showing WHERE movieTitle = " + movieTitle);

			  return new Movie(results.getString(0), results.getString(1), results.getInt(2), results.getString(3));	
			    } catch (SQLException e) {
			 
			  System.out.println("Could not retrieve data from the database " + e.getMessage());
			    }
		return null;
	 }
	 
	 public static Theatre getTheatre(String theatreName) {
		 try {
			 
			  // Get a result set containing all data from test_table
			 
			  Statement statement = connection.createStatement();
			 
			  ResultSet results = statement.executeQuery("SELECT * FROM Showing WHERE showingID = " + theatreName);

			  return new Theatre(results.getString(0));	
			    } catch (SQLException e) {
			 
			    	System.out.println("Could not retrieve data from the database " + e.getMessage());
			    }
		return null;
	 }
	 
	 public static Showing getShowing(String showingID) {
		 try {
			 
			  // Get a result set containing all data from test_table
			 
			  Statement statement = connection.createStatement();
			 
			  ResultSet results = statement.executeQuery("SELECT * FROM Showing WHERE showingID = "+showingID);

			  String movieTitle = results.getString(1);
			  String theatreName = results.getString(2);
			  int seatMapID = results.getInt(3);
			  int showTime = results.getInt(3);
			  ResultSet theMovie = statement.executeQuery("SELECT * FROM Movie WHERE movieTitle = " + movieTitle);
			  String dateReleased = theMovie.getString(1);
			  int movieLength = theMovie.getInt(2);
			  String genre = theMovie.getString(3);
			  
			  return new Showing(Integer.parseInt(showingID), showTime, new Movie(movieTitle, dateReleased, movieLength, genre), 
					  new Theatre(theatreName), new SeatMap(getSeats(seatMapID), seatMapID, showTime, showTime, showTime));
			 
			    } catch (SQLException e) {
			 
			  System.out.println("Could not retrieve data from the database " + e.getMessage());
			    }
		return null;
	 }
	 
	 public static Seat getSeat(String seatMapID, String seatNumber) {
		 try {
			 
			  // Get a result set containing all data from test_table
			 
			  Statement statement = connection.createStatement();
			 
			  ResultSet results = statement.executeQuery("SELECT * FROM Seat WHERE seatMapID = "+seatMapID+" AND seatNumber = "+seatNumber);
			 
			  return new Seat(results.getBoolean(0), results.getInt(1));	
			    } catch (SQLException e) {
			 
			  System.out.println("Could not retrieve data from the database " + e.getMessage());
			    }
		return null;
	 }
	 
	 public static SeatMap getSeatMap(String seatMapID) {
		 try {
			 
			  // Get a result set containing all data from test_table
			 
			  Statement statement = connection.createStatement();
			 
			  ResultSet results = statement.executeQuery("SELECT * FROM Movie WHERE seatMapID = "+seatMapID);
			 
			  return new SeatMap(getSeats(results.getInt(0)),results.getInt(0),results.getInt(1),results.getInt(2),results.getInt(3));

	
			    } catch (SQLException e) {
			 
			  System.out.println("Could not retrieve data from the database " + e.getMessage());
			    }
		return null;
	 }
	 
	 public static void insertMovie(Movie theMovie) {
		 try {
			 
				 	Statement statement = connection.createStatement();	 
				  	statement.executeUpdate("INSERT INTO Movie " + "VALUES ('"+theMovie.getMovieTitle()+"', '"+theMovie.getDateReleased()+"', "
				 	+theMovie.getMovieLength()+", '"+theMovie.getGenre()+"')");
				  	return;	
				  	
			    } catch (SQLException e) {
			 
			    	System.out.println("Could not retrieve data from the database " + e.getMessage());
			    
			    }
	 }
	 
	 public static void insertTheatre(Theatre theTheatre) {
		 try {
			 
				  Statement statement = connection.createStatement();
				  statement.executeUpdate("INSERT INTO Theatre " + "VALUES ('"+theTheatre.getTheatreName()+"')");
				  return;
				  
			  } catch (SQLException e) {
			 
				  System.out.println("Could not retrieve data from the database " + e.getMessage());
			  
			  }
	 }
	 
	 public static void insertShowing(Showing theShowing) {
		 try {
			 
			 	Statement statement = connection.createStatement();
			 	statement.executeUpdate("INSERT INTO Showing " + "VALUES ("+theShowing.getShowingID()+", '"+theShowing.getMovie().getMovieTitle()+"', '"
			 	+theShowing.getTheatre().getTheatreName()+"', "+theShowing.getSeatMap().getSeatMapID()+", "+theShowing.getShowtime()+")");
			 	return;
			  
		 	} catch (SQLException e) {
			 
		 		System.out.println("Could not retrieve data from the database " + e.getMessage());
		 	
		 	}
	 }
	 
	 public static void insertSeat(SeatMap theMap, Seat theSeat) {
		 try {
			 
				 	Statement statement = connection.createStatement();	 
				  	statement.executeUpdate("INSERT INTO Seat " + "VALUES ('"+theMap.getSeatMapID()+"', '"+theSeat.getSeatNumber()+"', "
				 	+theSeat.isVacant()+")");
				  	return;	
				  	
			    } catch (SQLException e) {
			 
			    	System.out.println("Could not retrieve data from the database " + e.getMessage());
			    
			    }
	 }
	 
	 public static void insertSeatMap(SeatMap theMap) {
		 try {
			 
				 	Statement statement = connection.createStatement();	 
				  	statement.executeUpdate("INSERT INTO SeatMap " + "VALUES ('"+theMap.getSeatMapID()+"', '"+theMap.getReservedSeatCount()+"', '"
				 	+theMap.getNumberOfRows()+"', '"+theMap.getNumberOfAvailableSeats()+"')");
				  	return;	
				  	
			    } catch (SQLException e) {
			 
			    	System.out.println("Could not retrieve data from the database " + e.getMessage());
			    
			    }
	 }
	 
	 public static void updateMovie(Movie theMovie) {
		 try {
			 
				 	PreparedStatement st = connection.prepareStatement("UPDATE Movie SET dateReleased = ?, movieLength = ?, genre = ?, WHERE movieTitle = ?");
				    st.setString(1, theMovie.getDateReleased());
				    st.setInt(2, theMovie.getMovieLength());
				    st.setString(3, theMovie.getGenre());
				    st.setString(4, theMovie.getMovieTitle());
				    st.executeUpdate(); 
				  	return;	
				  	
			    } catch (SQLException e) {
			 
			    	System.out.println("Could not retrieve data from the database " + e.getMessage());
			    
			    }
	 }
	 
	 public static void updateTheatre(Theatre theTheatre) {
		 try {
			 
			 	PreparedStatement st = connection.prepareStatement("UPDATE Theatre SET TheatreName = ?, WHERE theatreName = ?");
			    st.setString(1,theTheatre.getTheatreName());
			    st.setString(2, theTheatre.getTheatreName());
			    st.executeUpdate(); 
			  	return;	
				  
			  } catch (SQLException e) {
			 
				  System.out.println("Could not retrieve data from the database " + e.getMessage());
			  
			  }
	 }
	 
	 public static void updateShowing(Showing theShowing) {
		 try {
			 
			 	PreparedStatement st = connection.prepareStatement("UPDATE Showing SET movieTitle = ?, theatreName = ?, seatMapID = ?, showTime = ?, WHERE showingID = ?");
			    st.setString(1, theShowing.getMovie().getMovieTitle());
			    st.setString(2, theShowing.getTheatre().getTheatreName());
			    st.setInt(3, theShowing.getSeatMap().getSeatMapID());
			    st.setInt(4, theShowing.getShowtime());
			    st.setInt(5, theShowing.getShowingID());
			    st.executeUpdate(); 
			  	return;	
			  
		 	} catch (SQLException e) {
			 
		 		System.out.println("Could not retrieve data from the database " + e.getMessage());
		 	
		 	}
	 }
	 
	 public static void updateSeat(SeatMap theMap, Seat theSeat) {
		 try {
			 
			 		PreparedStatement st = connection.prepareStatement("UPDATE Seat SET seatNumber = ?, vacant = ?, WHERE seatMapID = ?");
				    st.setInt(1, theSeat.getSeatNumber());
				    st.setBoolean(2, theSeat.isVacant());
				    st.setInt(3, theMap.getSeatMapID());
				    st.executeUpdate(); 
				  	return;	
				  	
			    } catch (SQLException e) {
			 
			    	System.out.println("Could not retrieve data from the database " + e.getMessage());
			    
			    }
	 }
	 
	 public static void updateSeatMap(SeatMap theMap) {
		 try {
			 		PreparedStatement st = connection.prepareStatement("UPDATE SeatMap SET reservedSeatCount = ?, NumberOfRows = ?, numberOfAvailableSeats = ?, WHERE seatMapID = ?");
				    st.setInt(1, theMap.getReservedSeatCount());
				    st.setInt(2, theMap.getNumberOfRows());
				    st.setInt(3, theMap.getNumberOfAvailableSeats());
				    st.setInt(4, theMap.getSeatMapID());
				    st.executeUpdate(); 
				  	return;	
				  	
			    } catch (SQLException e) {
			 
			    	System.out.println("Could not retrieve data from the database " + e.getMessage());
			    
			    }
	 }
	
}
	



