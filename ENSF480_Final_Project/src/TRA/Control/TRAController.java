/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Control;

import TRA.Presentation.HomeScreen;
import TRA.Presentation.Screen;
import TRA.Presentation.TRAWindow;

/**
 * Controller of Ticket Reservation App
 */
public class TRAController extends Controller {

    private TRAWindow traWindow;
    private Screen currentFrame;

    public TRAController() {
    }

    /**
     * Start ticket reservation app and pass control to child controller based
     * on inputs to gui.
     */
    public void doAction(){
        //Open TRA window and initially set frame to homescreen
        HomeController homeController = new HomeController(this);
        this.currentFrame = new HomeScreen(homeController);
        this.traWindow = new TRAWindow(this);
        this.notifyObservers();
        //Start homeController
        homeController.doAction();
    }

    /**
     * Perform OrderSelection sequence
     */
    public void doOrderSelection() {
        System.out.println("Begin Order Selection");
    }

    public Screen getCurrentFrame() {
        return currentFrame;
    }

    public static void main(String args []) {
        TRAController traController = new TRAController();
        traController.doAction();
    }

}
