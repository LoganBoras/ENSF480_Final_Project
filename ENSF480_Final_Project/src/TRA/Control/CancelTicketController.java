package TRA.Control;

import TRA.Domain.*;
import TRA.Presentation.*;

import javax.swing.*;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class CancelTicketController extends Subject {
    private CancelTicketController itself;
    private JFrame frame;

    private ArrayList<String> data;	//1st index: email, 2nd index: ticketID
    private ArrayList<Ticket> tickets;
    private int ticketSelected;
    private Ticket t;
    private String email;
    private TRA tra;

    public CancelTicketController(JFrame frame, Subject subject) {
        this.frame = frame;
        setID(2);
        data = new ArrayList<String>();
        tra = new TRA();
    }

    public void runCancelTicketSelection(){

        runEmailInput();
        System.out.println("EmailInput Exited");

        tickets = tra.getOrder(data.get(0));
        email = data.get(0);

        runTicketSelection();
        System.out.println("TicketSelection Exited");

        ticketSelected = parseInt(data.get(1));
        for(int i = 0; i < tickets.size(); i++) {
            if(tickets.get(i).getTicketID() == ticketSelected) {
                t = tickets.get(i);
            }
        }

        System.out.println("USER SELECTED THE FOLLOWING: ");
        for(int j = 0; j < data.size(); j++) {
            System.out.println(data.get(j));
        }

        int orderID = tra.cancelTicket(parseInt(data.get(1)));

        tra.checkOrderStatus(orderID);

        runRefund();

        return;
    }

    private void runEmailInput() {
        int prevID;
        Screen Screen = new UserEmailScreen(frame, itself);
        Screen.buildScreen();

        prevID = getID();
        int i = 0;
        while(getID() == prevID) {
            if(i == 0)
                System.out.println("waiting for UserEmailScreen to finish...");
            i++;
        }
    }

    private void runTicketSelection() {
        int prevID;
        Screen Screen = new TicketSelectionScreen(frame, itself, tickets);
        Screen.buildScreen();

        prevID = getID();
        int i = 0;
        while(getID() == prevID) {
            if(i == 0)
                System.out.println("waiting for TicketSelectionScreen to finish...");
            i++;
        }
    }

    private void runRefund() {
        TicketRefundController refund = new TicketRefundController(this.frame, itself, t, email);
        refund.setItself(refund);
        refund.runRefund();
    }

    @Override
    public void addData(String data) {
        this.data.add(data);
    }

    public void setItself(CancelTicketController itself ) {
        this.itself = itself;
    }
}
