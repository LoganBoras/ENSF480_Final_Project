package TRA.Domain;

public abstract class Order {
    private double totalPrice;
    private final int orderID;
    private static int nextOrderID = 0;

    private int orderStatus;
    private static final int ORDER_STATUS_PENDING = 0;
    private static final int ORDER_STATUS_APPROVED = 1;
    private static final int ORDER_STATUS_REJECTED = 2;

    public Order() {
        this.orderID = nextOrderID++;
        this.orderStatus = ORDER_STATUS_PENDING;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    protected void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    /**
     * Sets order status to approved
     */
    public void approve() {
        this.orderStatus = Order.ORDER_STATUS_APPROVED;
    }

    /**
     * Sets order status to rejected
     */
    public void reject() {
        this.orderStatus = Order.ORDER_STATUS_REJECTED;
    }

    abstract public Receipt makeReceipt();

}
