package TRA.Control;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import TRA.Domain.Card;
import TRA.Presentation.MovieSelectionScreen;
import TRA.Presentation.OrderPaymentScreen;
import TRA.Presentation.Screen;

public class OrderPaymentController extends Subject{

	private OrderPaymentController itself;
	private JFrame frame;
	private ArrayList<String> data; //1st index is card#, 2nd is expiry, 3rd is CSV#	
	private Card userCard;
	
	public OrderPaymentController(JFrame frame, Subject subject) {
		this.frame = frame;
		setID(6);
	}
	
	public void runOrderPayment() {
		int prevID;
		Screen Screen = new OrderPaymentScreen(frame, itself);
		Screen.buildScreen();

		prevID = getID();
		int i = 0;
		while(getID() == prevID) {
			if(i == 0) 
				System.out.println("waiting for OrderPaymentScreen to finish...");
			i++;
			}
		
	}
	
	
	
	@Override
	public void addData(String data) {
		// TODO Auto-generated method stub
		
	}

	public void setItself(OrderPaymentController itself ) {
		this.itself = itself;
		
		
	}


	
	
	
}
