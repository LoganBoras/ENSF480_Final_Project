package TRA.Presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import TRA.Control.Subject;
import TRA.Domain.Movie;
import TRA.Domain.Showing;

public class ShowTimeSelectionScreen extends OrderSelectionScreen{
	
	ArrayList<Showing> showTimes;
	private JFrame frame;
	private Vector data;
	private JButton cancelBut = new JButton("Cancel");
	private JButton nextBut = new JButton("Next");
	private String showingSelection = null;
	
	public ShowTimeSelectionScreen(JFrame frame, Subject subject, ArrayList<Showing> showTimes) {
		this.frame = frame;
		this.subject = subject;
		this.showTimes = showTimes;
		createSelection();
	}
	
	@Override
	public void createSelection() {
		// TODO Auto-generated method stub
		this.list = new JList();
		data = new Vector();
		
		for(int i = 0; i < showTimes.size(); i++) {
			data.addElement(showTimes.get(i).getShowtime());
		}
		
		list.setListData(data);
	}

	@Override
	public void updateScreen() {
		// TODO Auto-generated method stub
		frame.getContentPane().removeAll();
		
		subject.setID(5);
		subject.addData(showingSelection);
		frame.repaint();
	}

	@Override
	public void displayScreen() {
		// TODO Auto-generated method stub
		System.out.println("We're in ShowTime Selection");
		frame.setLayout(new BorderLayout());
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width/4,Toolkit.getDefaultToolkit().getScreenSize().height/2);
		
		JPanel panel = new JPanel(new BorderLayout());
		
		JPanel buttons = new JPanel(new FlowLayout());
		buttons.add(cancelBut);
		buttons.add(nextBut);
		
		frame.add("North", new JLabel("ShowTime Selection"));
		panel.add("Center", list);
		panel.add("West", new JLabel("Please select the desired Showtime for the movie"));
		panel.add("South", buttons);
		
		frame.add("Center", panel);
		
		frame.setVisible(true);
		frame.repaint();
		
		controlButtons();
		
	}

	private void controlButtons() {
		// TODO Auto-generated method stub
		getCancelBut().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					frame.dispose();
					
			}});
		
		getList().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if(me.getClickCount() == 1) {
					JList target = (JList)me.getSource();
					int index = target.locationToIndex(me.getPoint());
					if(index >=0) {
						Object item = target.getModel().getElementAt(index);
						showingSelection = item.toString();
						System.out.println("user selected : " + showingSelection);
					}
					
				}
			}
		});
		
		getNextBut().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					if(showingSelection == null) {
						JOptionPane.showMessageDialog(new JFrame(), "You have not selected a show time yet!");
					}
					else {
						updateScreen();
					}
			}});
	}

	public ArrayList<Showing> getShowTimes() {
		return showTimes;
	}

	public void setShowTimes(ArrayList<Showing> showTimes) {
		this.showTimes = showTimes;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public Vector getData() {
		return data;
	}

	public void setData(Vector data) {
		this.data = data;
	}

	public JButton getCancelBut() {
		return cancelBut;
	}

	public void setCancelBut(JButton cancelBut) {
		this.cancelBut = cancelBut;
	}

	public JButton getNextBut() {
		return nextBut;
	}

	public void setNextBut(JButton nextBut) {
		this.nextBut = nextBut;
	}


	
	

}
