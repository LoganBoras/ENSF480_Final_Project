package TRA.Control;

import Database.DatabaseManager;
import TRA.Domain.RegisteredUser;

public class RegistrationController {
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
}
