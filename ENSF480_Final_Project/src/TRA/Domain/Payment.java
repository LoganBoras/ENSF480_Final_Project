package TRA.Domain;

public class Payment {
    private Card card;
    private double cost;
    private Order order;
    private int paymentID;

    public Payment(Card card, double cost, Order order, int paymentID) {
        this.card = card;
        this.cost = cost;
        this.order = order;
        this.paymentID = paymentID;
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

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }
}
