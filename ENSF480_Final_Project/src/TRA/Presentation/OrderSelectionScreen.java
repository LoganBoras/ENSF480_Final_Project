package TRA.Presentation;

import javax.swing.JList;

public abstract class OrderSelectionScreen extends Screen{
	
	public JList list;
	
	abstract public void createSelection();
	
	public JList getList() {
		return list;
	}
}
