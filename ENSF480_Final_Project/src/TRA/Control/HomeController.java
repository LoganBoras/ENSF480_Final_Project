package TRA.Control;

import java.util.ArrayList;

import javax.swing.JFrame;

import TRA.Presentation.HomeScreen;
import TRA.Presentation.Screen;

public class HomeController extends Subject{
	
	
	HomeController itself;
	private JFrame frame;
	private OrderSelectionController orderSelectionController;
	private CancelTicketController cancelTicketController;

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
					System.out.println("User Selected Cancel Ticket");
					doCancelTicketSelection();
					break;
				case 4:
					System.out.println("User Selected Order");
					doOrderSelection();
					return;
			}

		}
		
	}

	private void doOrderSelection() {
		// TODO Auto-generated method stub
		orderSelectionController = new OrderSelectionController(frame, itself);
		orderSelectionController.setItself(orderSelectionController);
		orderSelectionController.runOrderSelection();
	}

	private void doCancelTicketSelection() {
		// TODO Auto-generated method stub
		cancelTicketController = new CancelTicketController(frame, itself);
		cancelTicketController.setItself(cancelTicketController);
		cancelTicketController.runCancelTicketSelection();
	}

	@Override
	public void addData(String data) {
		// TODO Auto-generated method stub
		
	}
	
	public void setItself(HomeController itself) {
		this.itself = itself;
	}
	
}
