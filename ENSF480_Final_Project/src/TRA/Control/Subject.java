package TRA.Control;

public abstract class Subject {
	
	private int viewID; //ID of current GUI
	
	public void setID(int i) {
		this.viewID = i;
	}
	
	public int getID() {
		return this.viewID;
	}
	
	public abstract void setData(String data);
	
	
}
