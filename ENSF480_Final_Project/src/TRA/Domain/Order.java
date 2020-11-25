package TRA.Domain;

public class Order {
    private double totalPrice;
    private Payment payment;
    private int orderID;

    public Order(double totalPrice, Payment payment, int orderID) {
        this.totalPrice = totalPrice;
        this.payment = payment;
        this.orderID = orderID;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
}
