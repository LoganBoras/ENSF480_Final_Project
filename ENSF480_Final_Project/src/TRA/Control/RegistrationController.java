package TRA.Control;

import java.util.ArrayList;

import javax.swing.JFrame;

import Database.DatabaseManager;
import TRA.Domain.RegisteredUser;
import TRA.Presentation.RegistrationScreen;
import TRA.Presentation.Screen;

public class RegistrationController extends Subject{
	RegisteredUser theUser;
	static int accountID;
	String email;
	String fName;
	String lName;
	String password;
	int cardNum;
	String expDate;
	int csv;
	DatabaseManager db;
	private JFrame frame;
	private RegistrationController itself;
	
	public RegistrationController(JFrame frame, Subject subject) {
		db = new DatabaseManager();
		this.frame = frame;
		setID(4);	//ID for OrderSelection Frame;
		//data = new ArrayList<String>();
	}
	

	public void completeRegistration(int cardNum, String expDate, int csv, String email, String fName, String lName, String password) {
		accountID++;
		theUser = new RegisteredUser(accountID, cardNum, expDate, csv, email, fName, lName, password);
		db.registerUser(theUser);
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCardNum() {
		return cardNum;
	}
	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public int getCsv() {
		return csv;
	}
	public void setCsv(int csv) {
		this.csv = csv;
	}


	@Override
	public void addData(String data) {
		// TODO Auto-generated method stub
		
	}


	public void setItself(RegistrationController registrationController) {
		this.itself = registrationController;
	}


	public void runRegistration() {
		Screen Screen = new RegistrationScreen(frame, itself);
		Screen.buildScreen();
		
		int prevID = getID();
		int i = 0;
		while(getID() == prevID) {
			if(i == 0) 
				System.out.println("waiting for RegistrationScreen to finish...");
			i++;
			}
		System.out.println("exited while loop");
	}
}