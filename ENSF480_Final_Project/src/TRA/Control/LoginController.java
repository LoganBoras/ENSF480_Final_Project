package TRA.Control;

import java.util.ArrayList;

import javax.swing.JFrame;

import Database.DatabaseManager;
import TRA.Domain.RegisteredUser;
import TRA.Presentation.LoginScreen;
import TRA.Presentation.Screen;

public class LoginController extends Subject{
	RegisteredUser theUser;
	static int accountID;
	String email;
	String password;
	DatabaseManager db;
	private JFrame frame;
	private LoginController itself;
	
	public LoginController(JFrame frame, Subject subject) {
		db = new DatabaseManager();
		this.frame = frame;
		setID(7);	//ID for OrderSelection Frame;
		//data = new ArrayList<String>();
	}
	
	public void completeLogin(String email, String password) {
		accountID++;
		theUser = db.getUser(email, password);
	}

	@Override
	public void addData(String data) {
		// TODO Auto-generated method stub
		
	}


	public void setItself(LoginController registrationController) {
		this.itself = registrationController;
	}


	public void runLogin() {
		Screen Screen = new LoginScreen(frame, itself);
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
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public RegisteredUser getTheUser() {
		return theUser;
	}

	public void setTheUser(RegisteredUser theUser) {
		this.theUser = theUser;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public LoginController getItself() {
		return itself;
	}


}