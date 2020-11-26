package TRA.Domain;

import java.util.ArrayList;

public class TicketOrder {
    private ArrayList<Ticket> ticketList;

    public TicketOrder(ArrayList<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    public ArrayList<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(ArrayList<Ticket> ticketList) {
        this.ticketList = ticketList;
    }
}
