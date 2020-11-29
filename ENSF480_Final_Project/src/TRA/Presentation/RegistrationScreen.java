package TRA.Presentation;

import TRA.Control.RegistrationController;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import TRA.Control.Subject;

public class RegistrationScreen extends Screen{

	RegistrationController regController;

	JFrame frame; 
	private JLabel emailLabel = new JLabel("Email: ");
	private JTextField emailBox = new JTextField();
	private JLabel fNameLabel = new JLabel("First Name: ");
	private JTextField firstNameBox = new JTextField();
	private JLabel lNameLabel = new JLabel("Last Name: ");
	private JTextField lastNameBox = new JTextField();
	private JLabel passwordLabel = new JLabel("Password: ");
	private JTextField passwordBox = new JTextField();
	private JLabel cardLabel = new JLabel("Card Number: ");
	private JTextField cardNumberBox = new JTextField();
	private JLabel expiryLabel = new JLabel("Expiry Date: ");
	private JTextField expiryDateBox = new JTextField();
	private JLabel csvLabel = new JLabel("csv: ");
	private JTextField csvBox = new JTextField();
	private JButton confirmBut = new JButton("Confirm Information");
	private JButton cancelBut = new JButton("Cancel");

	
	public RegistrationScreen(JFrame frame, Subject subject){
		
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
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width/4,Toolkit.getDefaultToolkit().getScreenSize().height/6);
		frame.setLocationRelativeTo(null);
		
		JPanel buttons = new JPanel(new FlowLayout());
		buttons.add(emailLabel);
		buttons.add(emailBox);
		buttons.add(fNameLabel);
		buttons.add(firstNameBox);
		buttons.add(lNameLabel);
		buttons.add(lastNameBox);
		buttons.add(passwordLabel);
		buttons.add(passwordBox);
		buttons.add(cardLabel);
		buttons.add(cardNumberBox);
		buttons.add(expiryLabel);
		buttons.add(expiryDateBox);
		buttons.add(csvLabel);
		buttons.add(csvBox);
		buttons.add(confirmBut);
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
		
		getConfirmBut().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stug
					String email = emailBox.getText();
					String fName = firstNameBox.getText();
					String lName = lastNameBox.getText();
					String password = passwordBox.getText();
					int cardNum = Integer.parseInt(cardNumberBox.getText());
					String expDate = expiryDateBox.getText();
					int csv = Integer.parseInt(csvBox.getText());
					regController.completeRegistration(cardNum, expDate, csv, email, fName, lName, password);
					update();
			}});
		
	}

	public JButton getCancelBut() {
		return cancelBut;
	}

	public void setCancelBut(JButton cancelBut) {
		this.cancelBut = cancelBut;
	}

	public JTextField getEmailBox() {
		return emailBox;
	}

	public void setEmailBox(JTextField emailBox) {
		this.emailBox = emailBox;
	}

	public JTextField getFirstNameBox() {
		return firstNameBox;
	}

	public void setFirstNameBox(JTextField firstNameBox) {
		this.firstNameBox = firstNameBox;
	}

	public JTextField getLastNameBox() {
		return lastNameBox;
	}

	public void setLastNameBox(JTextField lastNameBox) {
		this.lastNameBox = lastNameBox;
	}

	public JTextField getPasswordBox() {
		return passwordBox;
	}

	public void setPasswordBox(JTextField passwordBox) {
		this.passwordBox = passwordBox;
	}

	public JTextField getCardNumberBox() {
		return cardNumberBox;
	}

	public void setCardNumberBox(JTextField cardNumberBox) {
		this.cardNumberBox = cardNumberBox;
	}

	public JTextField getExpiryDateBox() {
		return expiryDateBox;
	}

	public void setExpiryDateBox(JTextField expiryDateBox) {
		this.expiryDateBox = expiryDateBox;
	}

	public JTextField getCsvBox() {
		return csvBox;
	}

	public void setCsvBox(JTextField csvBox) {
		this.csvBox = csvBox;
	}

	public JButton getConfirmBut() {
		return confirmBut;
	}

	public void setConfirmBut(JButton confirmBut) {
		this.confirmBut = confirmBut;
	}

	
	
	
}
