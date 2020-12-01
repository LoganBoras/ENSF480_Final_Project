package TRA.Presentation;

import TRA.Control.HomeController;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import TRA.Control.Subject;
import TRA.Control.HomeController;

public class HomeScreen extends Screen{

	HomeController homeController;

	JFrame frame; 
	private JButton loginBut = new JButton("Login");
	private JButton orderBut = new JButton("Create Order");
	private JButton cancelTicketBut = new JButton("Cancel Ticket");
	private JButton cancelBut = new JButton("Cancel");
	private JButton movieAnnouncementBut = new JButton("Send Movie Announcement");

	
	public HomeScreen(JFrame frame, Subject subject){
		
		this.subject = subject;
		this.frame = frame;
		this.screenID = 2;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub

		frame.getContentPane().removeAll();
		frame.repaint();
		subject.setID(screenID);
		
		//System.out.println("did we change the same subject or a copy..." + subject.getID());
	}

	@Override
	public void buildScreen() {
		// TODO Auto-generated method stub
		//frame = new JFrame("Home Page");
		frame.setLayout(new BorderLayout());
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width/2,Toolkit.getDefaultToolkit().getScreenSize().height/6);
		frame.setLocationRelativeTo(null);
		
		JPanel buttons = new JPanel(new FlowLayout());
		buttons.add(loginBut);
		buttons.add(orderBut);
		buttons.add(cancelTicketBut);
		buttons.add(movieAnnouncementBut);
		buttons.add(cancelBut);
		

		frame.add("North", new JLabel("HOME PAGE :^)", SwingConstants.CENTER));
		frame.add("South", buttons);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		controlButtons();
		System.out.println("selection is now : " + screenID);
		
		controlButtons();
	}
	
	private void controlButtons() {
		
		getCancelBut().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					frame.dispose();
					
			}});
		
		getOrderBut().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stug

					update();
			}});

		getCancelTicketBut().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().removeAll();
				subject.setID(3);
				frame.repaint();
			}});
		
		getMovieAnnouncementBut().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				frame.getContentPane().removeAll();
				frame.repaint();
				subject.setID(HomeController.USER_SELECTION_MOVIE_ANNOUNCEMENT);
			}});


	}
	
//	public static void main(String args []) {
//		HomeScreen Screen = new HomeScreen();
//		int pog = Screen.buildScreen();
//		System.out.println("Returned value from screen : " + pog);
//		
//	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JButton getLoginBut() {
		return loginBut;
	}

	public void setLoginBut(JButton loginBut) {
		this.loginBut = loginBut;
	}

	public JButton getOrderBut() {
		return orderBut;
	}

	public void setOrderBut(JButton orderBut) {
		this.orderBut = orderBut;
	}

	public JButton getCancelBut() {
		return cancelBut;
	}

	public void setCancelBut(JButton cancelBut) {
		this.cancelBut = cancelBut;
	}

	public JButton getCancelTicketBut() {
		return cancelTicketBut;
	}
	
	public JButton getMovieAnnouncementBut() {
		return movieAnnouncementBut;
	}
}
