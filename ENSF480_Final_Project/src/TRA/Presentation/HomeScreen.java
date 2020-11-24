package TRA.Presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HomeScreen extends Screen{

	JFrame frame; 
	private JButton loginBut = new JButton("Login");
	private JButton orderBut = new JButton("Create Order");
	private JButton cancelBut = new JButton("Cancel");
	int selection = -1;
	
	HomeScreen(){
	}
	
	@Override
	public void updateScreen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int displayScreen() {
		// TODO Auto-generated method stub
		frame = new JFrame("Home Page");
		frame.setLayout(new BorderLayout());
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width/4,Toolkit.getDefaultToolkit().getScreenSize().height/6);
		frame.setLocationRelativeTo(null);
		
		JPanel buttons = new JPanel(new FlowLayout());
		buttons.add(loginBut);
		buttons.add(orderBut);
		buttons.add(cancelBut);
		
		frame.add("North", new JLabel("HOME PAGE :^)", SwingConstants.CENTER));
		frame.add("South", buttons);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		return controlButtons();
		
		
		
		
	}
	
	private int controlButtons() {
		
		getCancelBut().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					frame.dispose();
					
			}});
		
		getOrderBut().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					setSelection(2);
					System.out.println("Order Button Pressed, selection returned is : " + getSelection());
					frame.dispose();
					
			}});
		
		return selection;
	}
	
	public static void main(String args []) {
		HomeScreen Screen = new HomeScreen();
		int pog = Screen.displayScreen();
		System.out.println("Returned value from screen : " + pog);
		
	}

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

	public int getSelection() {
		return selection;
	}

	public void setSelection(int selection) {
		this.selection = selection;
	}
	
	
	
}
