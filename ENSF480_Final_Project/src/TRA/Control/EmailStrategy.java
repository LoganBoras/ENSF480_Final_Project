/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Control;

import TRA.Domain.Email;

/**
 * Abstract base class for different implementations of algorithms that send
 * emails.
 */
abstract public class EmailStrategy {

    Email email;
    String message;

    public abstract void perform();

    /**
     * Creates file and appends email message to file
     */
    protected void sendEmail() {
        System.out.println(email.toString());
    }

}
