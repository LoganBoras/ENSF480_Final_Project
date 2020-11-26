/* ENSF 480 - TRA Final Project 
Group 3, November 2020
*/

package TRA.Presentation;

import javax.swing.*;

public abstract class Screen extends JPanel implements Observer {
	
	abstract public void update() ;
	
	abstract public int buildScreen();
}
