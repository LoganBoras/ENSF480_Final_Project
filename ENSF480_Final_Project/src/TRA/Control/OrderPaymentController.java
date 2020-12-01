package TRA.Control;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import TRA.Domain.Card;
import TRA.Domain.Receipt;
import TRA.Domain.TRA;
import TRA.Domain.TicketOrder;
import TRA.Presentation.MovieSelectionScreen;
import TRA.Presentation.OrderPaymentScreen;
import TRA.Presentation.Screen;

public class OrderPaymentController extends Subject{

	private OrderPaymentController itself;
	private JFrame frame;
	private ArrayList<String> data; //1st index is email, 2nd index is card#, 3rd is expiry, 4th is CSV#	
	private String email;
	private Card userCard;
	private TicketOrder order;
	
	public OrderPaymentController(JFrame frame, Subject subject, TicketOrder order) {
		this.frame = frame;
		this.order = order;
		this.data = new ArrayList<String>();
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
		 email = data.get(0);
		 userCard = new Card(data.get(1), data.get(2), Integer.parseInt(data.get(3)));
		
		 runPaymentProcess();
		
	}
	
	
	
	private void runPaymentProcess() {
		// TODO Auto-generated method stub
		TicketOrderPaymentStrategy ticketPaymentStrategy = new TicketOrderPaymentStrategy(userCard, new TRA(), email, order);
		PaymentController paymentController = new PaymentController(ticketPaymentStrategy);
		paymentController.doAction();
		
		if(order.getOrderStatus() == 1) {
			JOptionPane.showMessageDialog(new JFrame(), "Payment Successful! Please check you email for your ticket(s) and "
					+ "payment receipt!");
			sendTicketEmail();
		}
		else {
			JOptionPane.showMessageDialog(new JFrame(), "Payment failed. Please try again.");
		}
		
		
	}

	private void sendTicketEmail() {
		// TODO Auto-generated method stub
		TicketEmailStrategy ticketEmailStrategy = new 	TicketEmailStrategy(email, order.getTicketListCopy());
		SendEmailController sendEmailController = new SendEmailController(ticketEmailStrategy);
		sendEmailController.doAction();
	}

	@Override
	public void addData(String data) {
		// TODO Auto-generated method stub
		this.data.add(data);
	}

	public void setItself(OrderPaymentController itself ) {
		this.itself = itself;
		
		
	}


	
	
	
}
