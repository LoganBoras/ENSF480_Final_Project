package TRA.Presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class SeatSelectionButton extends JButton implements ActionListener{
	boolean vacancy;
	ImageIcon Reserved, Vacant;
	ArrayList<Integer> selectedSeat;
	int seatID;
	
	public SeatSelectionButton(ArrayList<Integer> selectedSeat, int i, boolean vacancy) {
		// TODO Auto-generated constructor stub
		Reserved = new ImageIcon("ENSF480_Final_Project/reserved.png");
		Vacant = new ImageIcon("ENSF480_Final_Project/vacant.png");
		this.vacancy = vacancy;
		if(vacancy) {
			setIcon(Vacant);
		}
		else {
			setIcon(Reserved);
			setEnabled(false);
		}
		this.selectedSeat = selectedSeat;
		this.seatID = i;
		this.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(selectedSeat.size() ==0) {
			setIcon(Reserved);
			System.out.println("selected seat for seat #: " + seatID + " is : " + selectedSeat.toString());
			selectedSeat.add(seatID);
			repaint();
		}
		else if(selectedSeat.get(0) == seatID) {
			selectedSeat.remove(0);
			setIcon(Vacant);
			repaint();
		}
		else {
			JOptionPane.showMessageDialog(new JFrame(), "You have already selected a seat, unselect it and try again");
		}
	}



}
