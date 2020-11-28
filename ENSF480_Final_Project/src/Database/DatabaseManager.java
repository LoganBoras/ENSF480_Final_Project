package Database;

import TRA.Domain.Movie;
import TRA.Domain.Theatre;

import java.util.ArrayList;

//TODO - I commented out everything and added these dummy functions so the code
// will compile. Whoever is making this class - please make sure it compiles
// before commiting it to master
public class DatabaseManager {

	public ArrayList<Movie> getMovies() {
		return null;
	}

	public ArrayList<Theatre> getTheatres() {
		return null;
	}
}

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//import TRA.Domain.Movie;
//import TRA.Domain.Seat;
//import TRA.Domain.Showing;
//import TRA.Domain.Theatre;
//
//public class DatabaseManager {
//	  static Connection connection=null;
//
//public static void initialize(String[] args) {
//
//
//	try {
//
//	// Load the MySQL JDBC driver
//
//	String driverName = "com.mysql.jdbc.Driver";
//
//	Class.forName(driverName);
//
//
//	// Create a connection to the database
//
//	String serverName = "localhost";
//
//	String schema = "test";
//
//	String url = "jdbc:mysql://" + serverName +  "/" + schema;
//
//	String username = "root";
//
//	String password = "ENSF480TRA";
//
//	connection = DriverManager.getConnection(url, username, password);
//
//
//
//	System.out.println("Successfully Connected to the database!");
//
//
//	  } catch (ClassNotFoundException e) {
//
//	System.out.println("Could not find the database driver " + e.getMessage());
//	  } catch (SQLException e) {
//
//	System.out.println("Could not connect to the database " + e.getMessage());
//	  }
//
//	}
//
//	 public static ArrayList<Movie> getMovies() {
//		 try {
//
//			  // Get a result set containing all data from test_table
//
//			  Statement statement = connection.createStatement();
//
//			  ResultSet results = statement.executeQuery("SELECT * FROM Movie");
//
//			  // For each row of the result set ...
//			  ArrayList<Movie> movieResults = new ArrayList<Movie>();
//			  while (results.next()) {
//
//
//			  // Get the data from the current row using the column name - column data are in the VARCHAR format
//			  String movieTitle = results.getString(0);
//			  String dateReleased = results.getString(1);
//			  int movieLength = results.getInt(2);
//			  String genre = results.getString(3);
//
//			  movieResults.add(new Movie(movieTitle, dateReleased, movieLength, genre));
//
//			}
//				 return movieResults;
//
//			    } catch (SQLException e) {
//
//			  System.out.println("Could not retrieve data from the database " + e.getMessage());
//			    }
//		return null;
//	 }
//
//	 public static ArrayList<Theatre> getTheatres() {
//		 try {
//
//			  // Get a result set containing all data from test_table
//
//			  Statement statement = connection.createStatement();
//
//			  ResultSet results = statement.executeQuery("SELECT * FROM Theatre");
//
//			  // For each row of the result set ...
//			  ArrayList<Theatre> theatreResults = new ArrayList<Theatre>();
//			  while (results.next()) {
//
//
//			  // Get the data from the current row using the column name - column data are in the VARCHAR format
//			  String theatreName = results.getString(0);
//
//
//			  theatreResults.add(new Theatre(theatreName));
//
//
//			  }
//				 return theatreResults;
//
//			    } catch (SQLException e) {
//
//			  System.out.println("Could not retrieve data from the database " + e.getMessage());
//			    }
//		return null;
//	 }
//
//	 public static ArrayList<Showing> getShowings() {
//		 try {
//
//			  // Get a result set containing all data from test_table
//
//			  Statement statement = connection.createStatement();
//
//			  ResultSet results = statement.executeQuery("SELECT * FROM Movie");
//
//			  // For each row of the result set ...
//			  String data;
//			  ArrayList<Showing> showingResults = new ArrayList<Showing>();
//			  while (results.next()) {
//
//
//			  // Get the data from the current row using the column name - column data are in the VARCHAR format
//			  String showingID = results.getString(0);
//			  String movieTitle = results.getString(1);
//			  String theatreName = results.getString(2);
//			  String seatMapID = results.getString(3);
//			  String showTime = results.getString(3);
//
//			  showingResults.add(new Showing(showingID, movieTitle, theatreName, seatMapID, showTime));
//
//
//			}
//				 return showingResults;
//
//			    } catch (SQLException e) {
//
//			  System.out.println("Could not retrieve data from the database " + e.getMessage());
//			    }
//	 }
//
//	 public static ArrayList<Seat> getSeats() {
//		 try {
//
//			  // Get a result set containing all data from test_table
//
//			  Statement statement = connection.createStatement();
//
//			  ResultSet results = statement.executeQuery("SELECT * FROM Movie");
//
//			  // For each row of the result set ...
//			  String data;
//			  ArrayList<Seat> seatResults = new ArrayList<Seat>();
//			  while (results.next()) {
//
//
//			  // Get the data from the current row using the column name - column data are in the VARCHAR format
//			  Boolean vacant = results.getBoolean(0);
//			  int seatNumber = results.getInt(1);
//
//			  seatResults.add(new Seat(vacant, seatNumber));
//
//
//			}
//				 return seatResults;
//
//			    } catch (SQLException e) {
//
//			  System.out.println("Could not retrieve data from the database " + e.getMessage());
//			    }
//	 }
//
//	 public static ArrayList<SeatMap> getSeatMaps() {
//		 try {
//
//			  // Get a result set containing all data from test_table
//
//			  Statement statement = connection.createStatement();
//
//			  ResultSet results = statement.executeQuery("SELECT * FROM Movie");
//
//			  // For each row of the result set ...
//			  String data;
//			  ArrayList<seatMap> seatMapResults = new ArrayList<seatMap>();
//			  while (results.next()) {
//
//
//			  // Get the data from the current row using the column name - column data are in the VARCHAR format
//			  String seatMapID = results.getString(0);
//			  String reservedSeatCount = results.getString(1);
//			  String numberOfRows = results.getString(2);
//			  String numberOfAvailableSeats = results.getString(3);
//
//			  seatMapResults.add(new seatMap(seatMapID, reservedSeatCount, numberOfRows, numberOfAvailableSeats));
//
//
//			}
//				 return seatMapResults;
//
//			    } catch (SQLException e) {
//
//			  System.out.println("Could not retrieve data from the database " + e.getMessage());
//			    }
//	 }
//
//	 public static Movie getMovie(String movieTitle) {
//		 try {
//
//			  // Get a result set containing all data from test_table
//
//			  Statement statement = connection.createStatement();
//
//			  ResultSet results = statement.executeQuery("SELECT * FROM Showing WHERE movieTitle = " + movieTitle);
//
//			  return new Movie(results.getString(0), results.getString(1), results.getInt(2), results.getString(3));
//			    } catch (SQLException e) {
//
//			  System.out.println("Could not retrieve data from the database " + e.getMessage());
//			    }
//		return null;
//	 }
//
//	 public static Theatre getTheatre(String theatreName) {
//		 try {
//
//			  // Get a result set containing all data from test_table
//
//			  Statement statement = connection.createStatement();
//
//			  ResultSet results = statement.executeQuery("SELECT * FROM Showing WHERE showingID = " + theatreName);
//
//			  return new Theatre(results.getString(0));
//			    } catch (SQLException e) {
//
//			    	System.out.println("Could not retrieve data from the database " + e.getMessage());
//			    }
//		return null;
//	 }
//
//	 public static Showing getShowing(String showingID) {
//		 try {
//
//			  // Get a result set containing all data from test_table
//
//			  Statement statement = connection.createStatement();
//
//			  ResultSet results = statement.executeQuery("SELECT * FROM Showing WHERE showingID = "+showingID);
//
//			  return new Showing(results.getString(0), results.getString(1), results.getString(2), results.getString(3), results.getString(4));
//			    } catch (SQLException e) {
//
//			  System.out.println("Could not retrieve data from the database " + e.getMessage());
//			    }
//	 }
//
//	 public static Seat getSeat(String seatMapID, String seatNumber) {
//		 try {
//
//			  // Get a result set containing all data from test_table
//
//			  Statement statement = connection.createStatement();
//
//			  ResultSet results = statement.executeQuery("SELECT * FROM Seat WHERE seatMapID = "+seatMapID+" AND seatNumber = "+seatNumber);
//
//			  return new Seat(results.getBoolean(0), results.getInt(1));
//			    } catch (SQLException e) {
//
//			  System.out.println("Could not retrieve data from the database " + e.getMessage());
//			    }
//		return null;
//	 }
//
//	 public static SeatMap getSeatMap(String seatMapID) {
//		 try {
//
//			  // Get a result set containing all data from test_table
//
//			  Statement statement = connection.createStatement();
//
//			  ResultSet results = statement.executeQuery("SELECT * FROM Movie WHERE seatMapID = "+seatMapID);
//
//			  return new SeatMap(results.getString(0),results.getString(1),results.getString(2),results.getString(3));
//
//
//			    } catch (SQLException e) {
//
//			  System.out.println("Could not retrieve data from the database " + e.getMessage());
//			    }
//	 }
//
//	 public static void insertMovie(Movie theMovie) {
//		 try {
//
//				 	Statement statement = connection.createStatement();
//				  	statement.executeUpdate("INSERT INTO Movie " + "VALUES ('"+theMovie.getMovieTitle()+"', '"+theMovie.getDateReleased()+"', "
//				 	+theMovie.getMovieLength()+", '"+theMovie.getGenre()+"')");
//				  	return;
//
//			    } catch (SQLException e) {
//
//			    	System.out.println("Could not retrieve data from the database " + e.getMessage());
//
//			    }
//	 }
//
//	 public static void insertTheatre(Theatre theTheatre) {
//		 try {
//
//				  Statement statement = connection.createStatement();
//				  statement.executeUpdate("INSERT INTO Theatre " + "VALUES ('"+theTheatre.getTheatreName()+"')");
//				  return;
//
//			  } catch (SQLException e) {
//
//				  System.out.println("Could not retrieve data from the database " + e.getMessage());
//
//			  }
//	 }
//
//	 public static void insertShowing(Showing theShowing) {
//		 try {
//
//			 	Statement statement = connection.createStatement();
//			 	statement.executeUpdate("INSERT INTO Showing " + "VALUES ("+theShowing.getShowingID()+", '"+theShowing.getMovie().getMovieTitle()+"', '"
//			 	+theShowing.getTheatre().getTheatreName()+"', "+theShowing.getSeatMap().getSeatMapID()+", "+theShowing.getShowtime()+")");
//			 	return;
//
//		 	} catch (SQLException e) {
//
//		 		System.out.println("Could not retrieve data from the database " + e.getMessage());
//
//		 	}
//	 }
//
//	 public static void insertSeat(Seat theSeat) {
//		 try {
//
//				 	Statement statement = connection.createStatement();
//				  	statement.executeUpdate("INSERT INTO Seat " + "VALUES ('"+theSeat.getSeatMap().getSeatMapID()+"', '"+theSeat.getSeatNumber()+"', "
//				 	+theSeat.isVacant()+")");
//				  	return;
//
//			    } catch (SQLException e) {
//
//			    	System.out.println("Could not retrieve data from the database " + e.getMessage());
//
//			    }
//	 }
//
//	 public static void insertSeatMap(SeatMap theMap) {
//		 try {
//
//				 	Statement statement = connection.createStatement();
//				  	statement.executeUpdate("INSERT INTO SeatMap " + "VALUES ('"+theMap.getID()+"', '"+theMap.getReservedSeatCount()+"', '"
//				 	+theMap.getNumRows()+"', '"+theMap.getAvailableSeatNum()+"')");
//				  	return;
//
//			    } catch (SQLException e) {
//
//			    	System.out.println("Could not retrieve data from the database " + e.getMessage());
//
//			    }
//	 }
//
//}
//
//
//
//
