/* ENSF 480 - TRA Final Project 
Group 3, November 2020
*/

package TRA.Presentation;


import TRA.Control.Subject;

public abstract class Screen {
	
	public Subject subject;
	public int screenID;
	
	abstract public void update() ;
	

	abstract public void buildScreen();
	
}
