/* ENSF 480 - TRA Final Project
   Group 3, November 2020
*/

package TRA.Control;

import FinancialInstitute.FinancialInstitute;
import TRA.Domain.*;

import java.util.ArrayList;

public class TicketOrderPaymentStrategy extends PaymentStrategy {

    private final TicketOrder ticketOrder;

    public TicketOrderPaymentStrategy(Card card,
                                      TRA tra, String receiptEmailAddress, TicketOrder ticketOrder) {
        super(card, tra, receiptEmailAddress);
        this.ticketOrder = ticketOrder;
    }

    /**
     * Builds payment from ticket order and card info and sends it to financial
     * institute for processing.  If the payment is accepted, a receipt for the
     * ticket purchase is send. (The tickets are not sent in this email, though.)
     * Marks the TicketOrder as either accepted or rejected.
     */
    public void perform() {
        //create and process payment
        Payment payment = new Payment(this.card, this.ticketOrder);
        this.tra.sendPaymentToFinancialInstituteForProcessing(payment);

        //If payment is accepted, send email
        if (payment.isAccepted()) {
            this.ticketOrder.approve();

            Receipt receipt = new Receipt(this.ticketOrder);
            ReceiptEmailStrategy strategy = new ReceiptEmailStrategy(this.receiptEmailAddress, receipt);
            SendEmailController emailController = new SendEmailController(strategy);
            emailController.doAction();

        } else if (payment.isRejected()) {
            this.ticketOrder.reject();
        }
    }

}
