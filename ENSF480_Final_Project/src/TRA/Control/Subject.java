/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Control;

import TRA.Presentation.Observer;

/**
 * Subject in subject / observer design pattern.
 */
public interface Subject {

    /**
     * Add observer to observer list
     * @param observer that will be added
     */
    public void addObserver(Observer observer);

    /**
     * Remove observer from observer list
     * @param observer that will be removed
     */
    public void removeObserver(Observer observer);

    /**
     * Notify all observers in observer list to update themselves
     */
    public void notifyObservers();

}
