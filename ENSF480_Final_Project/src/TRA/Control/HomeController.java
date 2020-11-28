package TRA.Control;

import java.util.ArrayList;

import javax.swing.JFrame;

import TRA.Presentation.HomeScreen;
import TRA.Presentation.Screen;

public class HomeController extends Subject{
	
	
	HomeController itself;
	private JFrame frame;
	private OrderSelectionController orderSelectionController;

	public HomeController(JFrame frame) {
		this.frame = frame;
		setID(1);
	}

	public void runHome() {
		
		
		while(true) {
			setID(1);
			int prevID = getID();
			Screen Screen = new HomeScreen(frame, itself);
			Screen.displayScreen();
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
					return;
				case 4:
					System.out.println("User Selected Order");
					doOrderSelection();
					return;
			}
		
		}
		
	}

	private void doAction() {
		// TODO Auto-generated method stub
		orderSelectionController = new OrderSelectionController(frame, itself);
		orderSelectionController.setItself(orderSelectionController);
		orderSelectionController.runOrderSelection();
	}

	@Override
	public void addData(String data) {
		// TODO Auto-generated method stub
		
	}
	
	public void setItself(HomeController itself) {
		this.itself = itself;
	}
	
}
