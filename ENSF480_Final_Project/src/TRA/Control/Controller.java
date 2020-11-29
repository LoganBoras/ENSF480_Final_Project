/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Control;

import TRA.Domain.TRA;
import TRA.Presentation.Observer;

import java.util.ArrayList;

/**
 * Parent class of all controllers.
 */
abstract class Controller extends Subject{

 //   private final ArrayList<Observer> observerList;

    //Only tra instance that is shared by all controllers
    private static TRA tra;

//    public Controller() {
//        this.observerList = new ArrayList<Observer>();
//        if (Controller.tra == null) {
//            Controller.tra = new TRA();
//        }
//    }
//
//    /**
//     * Add observer to observer list
//     * @param observer that will be added
//     */
//    @Override
//    public void addObserver(Observer observer) {
//        this.observerList.add(observer);
//    }
//
//    /**
//     * Remove observer from observer list
//     * @param observer that will be removed
//     */
//    public void removeObserver(Observer observer) {
//        this.observerList.remove(observer);
//    }
//
//    /**
//     * Notify all observers in observer list to update themselves
//     */
//    public void notifyObservers() {
//        for (Observer observer : observerList) {
//            observer.update();
//        }
//    }

    /**
     * Perform sequence of events controller handles
     */
    abstract public void doAction();

}
