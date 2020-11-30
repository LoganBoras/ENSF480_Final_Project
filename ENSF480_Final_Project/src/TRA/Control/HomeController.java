package TRA.Control;

import java.util.ArrayList;

import javax.swing.JFrame;

import TRA.Presentation.HomeScreen;
import TRA.Presentation.Screen;

public class HomeController extends Subject{
	
	
	HomeController itself;
	private JFrame frame;
	private OrderSelectionController orderSelectionController;
	private RegistrationController registrationController;
	private LoginController loginController;

	public HomeController(JFrame frame) {
		this.frame = frame;
		setID(1);
	}

	public void doAction() {
		
		
		while(true) {
			setID(1);
			int prevID = getID();
			Screen Screen = new HomeScreen(frame, itself);
			Screen.buildScreen();
			System.out.println("This is the ID: " + getID());
			int i = 0;
			while(getID() == prevID) {
				if(i == 0)
					System.out.println("Waiting for button press on HomeScreen...");
				i++;
			}
			System.out.println("We have exited the while loop!!11!!!");
			switch (getID()) {
				case 2:
					System.out.println("User Selected Order");
					doOrderSelection();
					break;
				case 3:
					System.out.println("User Selected ");
					doOrderSelection();
					break;
				case 4:
					System.out.println("User Selected Registration");
					doRegistration();
					break;
				case 7:
					System.out.println("User Selected Registration");
					doLogin();
					break;
			}
		
		}
		
	}

	private void doOrderSelection() {
		// TODO Auto-generated method stub
		orderSelectionController = new OrderSelectionController(frame, itself);
		orderSelectionController.setItself(orderSelectionController);
		orderSelectionController.runOrderSelection();
	}
	
	private void doRegistration() {
		// TODO Auto-generated method stub
		registrationController = new RegistrationController(frame, itself);
		registrationController.setItself(registrationController);
		registrationController.runRegistration();
	}
	
	private void doLogin() {
		// TODO Auto-generated method stub
		loginController = new LoginController(frame, itself);
		loginController.setItself(loginController);
		loginController.runLogin();
	}

	@Override
	public void addData(String data) {
		// TODO Auto-generated method stub
		
	}
	
	public void setItself(HomeController itself) {
		this.itself = itself;
	}
	
}
