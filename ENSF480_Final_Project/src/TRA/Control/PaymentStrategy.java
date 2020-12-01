package TRA.Control;

import FinancialInstitute.FinancialInstitute;
import TRA.Domain.Card;
import TRA.Domain.TRA;

abstract public class PaymentStrategy {

    protected final Card card;
    protected final TRA tra;
    protected final String receiptEmailAddress;

    public PaymentStrategy(Card card,
                           TRA tra,
                           String receiptEmailAddress) {
        this.card = card;
        this.tra = tra;
        this.receiptEmailAddress = receiptEmailAddress;
    }

    abstract public void perform();

}