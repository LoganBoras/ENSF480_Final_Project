package TRA.Domain;

public class Payment {
    private Card card;
    private double cost;
    private Order order;
    private final int paymentID;
    private static int nextPaymentID;

    public static final int PAYMENT_STATUS_PENDING = 0;
    public static final int PAYMENT_STATUS_ACCEPTED = 1;
    public static final int PAYMENT_STATUS_REJECTED = 2;
    private int status; //accepted, rejected or pending

    public Payment(Card card, Order order) {
        this.card = card;
        this.cost = order.getTotalPrice();
        this.order = order;
        this.paymentID = nextPaymentID++;
        this.status = PAYMENT_STATUS_PENDING;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public boolean isPending() {
        return this.status == PAYMENT_STATUS_PENDING;
    }

    public boolean isAccepted() {
        return this.status == PAYMENT_STATUS_ACCEPTED;
    }

    public boolean isRejected() {
        return this.status == PAYMENT_STATUS_REJECTED;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
