/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Domain;

/**
 * Email message class.
 */
abstract public class Email {

    private final String toAddress;
    private final String fromAddress = "tra@tra.com";

    public Email(String toAddress) {
        this.toAddress = toAddress;
    }

    protected String makeHeader() {
        return "To: " + toAddress + "\n\nFrom: " + fromAddress + "\n\n";
    }

    @Override
    public abstract String toString();
}
