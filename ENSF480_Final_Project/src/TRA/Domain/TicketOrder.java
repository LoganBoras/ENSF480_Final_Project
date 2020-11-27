package TRA.Domain;

import java.util.ArrayList;

public class TicketOrder extends Order {
    private ArrayList<Ticket> ticketList;

    public TicketOrder(ArrayList<Ticket> ticketList, double totalPrice, Payment payment, int orderID) {
        super(totalPrice, payment, orderID);
        this.ticketList = ticketList;
    }

    public void addTicket(Ticket ticket) {
        ticketList.add(ticket);
    }

    public void updateOrder(ArrayList<Ticket> tickets) {
        ticketList = tickets;
    }

    public ArrayList<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(ArrayList<Ticket> ticketList) {
        this.ticketList = ticketList;
    }
}
