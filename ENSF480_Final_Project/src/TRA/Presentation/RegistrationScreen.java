package TRA.Presentation;

import TRA.Control.RegistrationController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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

	
	public RegistrationScreen(JFrame frame, RegistrationController subject){
		
		this.subject = subject;
		this.regController = subject;
		this.frame = frame;
		this.screenID = 5;
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
		frame.setSize(400,225);
		frame.setLocationRelativeTo(null);
		
		JPanel text = new JPanel(new GridLayout(0,2));
		text.add(emailLabel);
		text.add(emailBox);
		text.add(fNameLabel);
		text.add(firstNameBox);
		text.add(lNameLabel);
		text.add(lastNameBox);
		text.add(passwordLabel);
		text.add(passwordBox);
		text.add(cardLabel);
		text.add(cardNumberBox);
		text.add(expiryLabel);
		text.add(expiryDateBox);
		text.add(csvLabel);
		text.add(csvBox);
		
		JPanel buttons = new JPanel(new FlowLayout());
		buttons.add(confirmBut);
		buttons.add(cancelBut);
		
		frame.add("North", text);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
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
					Boolean correct = true;
					String email = emailBox.getText();
					String fName = firstNameBox.getText();
					String lName = lastNameBox.getText();
					String password = passwordBox.getText();
					String cardNum = cardNumberBox.getText();
					String expDate = expiryDateBox.getText();
					String csv = csvBox.getText();
					
					if(email.isEmpty()) {
						emailLabel.setOpaque( true );
						emailLabel.setBackground(Color.RED);
						correct = false;
					}else {
						emailLabel.setOpaque( false );
					}
					
					if(fName.isEmpty()) {
						fNameLabel.setOpaque( true );
						fNameLabel.setBackground(Color.RED);
						correct = false;
					}else {
						fNameLabel.setOpaque( false );
					}
					
					if(lName.isEmpty()) {
						lNameLabel.setOpaque( true );
						lNameLabel.setBackground(Color.RED);
						correct = false;
					}else {
						lNameLabel.setOpaque( false );
					}
					
					if(password.isEmpty()) {
						passwordLabel.setOpaque( true );
						passwordLabel.setBackground(Color.RED);
						correct = false;
					}else {
						passwordLabel.setOpaque( false );
					}
					
					if(cardNum.isEmpty()) {
						cardLabel.setOpaque( true );
						cardLabel.setBackground(Color.RED);
						correct = false;
					}else {
						cardLabel.setOpaque( false );
					}
					
					if(expDate.isEmpty()) {
						expiryLabel.setOpaque( true );
						expiryLabel.setBackground(Color.RED);
						correct = false;
					}else {
						expiryLabel.setOpaque( false );
					}
					
					if(csv.isEmpty()) {
						csvLabel.setOpaque( true );
						csvLabel.setBackground(Color.RED);
						correct = false;
					}else {
						csvLabel.setOpaque( false );
					}
					
					if(correct) {
						regController.completeRegistration(Integer.parseInt(cardNum), expDate, Integer.parseInt(csv), email, fName, lName, password);
						System.out.println("new user registered");
						update();
					}
					

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
