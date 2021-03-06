package TRA.Presentation;

import TRA.Control.Subject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class TicketRefundScreen extends Screen {

    private JButton confirmBut = new JButton("Confirm Refund");
    private JButton cancelBut = new JButton("Exit");
    private JLabel cardLabel= new JLabel("Card Number:");
    private JLabel expiryLabel = new JLabel("Expiry Date:");
    private JLabel csvLabel = new JLabel("CSV:");
    private JTextField cardNumber = new JTextField(15);
    private JTextField expiryDate = new JTextField(15);
    private JTextField csv = new JTextField(15);

    private JFrame frame;

    public TicketRefundScreen(JFrame frame, Subject subject) {
        // TODO Auto-generated constructor stub
        this.subject = subject;
        this.frame = frame;
        this.screenID = 4;
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
    public void update() {
        subject.addData(getCardNumber().getText());
        subject.addData(getExpiryDate().getText());
        subject.addData(getCsv().getText());

        frame.getContentPane().removeAll();
        frame.repaint();
        subject.setID(1);
    }

    public static void main(String args []) {
        OrderPaymentScreen screen = new OrderPaymentScreen();
        screen.buildScreen();
    }

	/**
	 * {@inheritDoc}
	 */
    @Override
    public void buildScreen() {
        frame.setLayout(new BorderLayout());
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width/4,Toolkit.getDefaultToolkit().getScreenSize().height/4);

        JPanel paymentPanel = new JPanel();
        paymentPanel.setLayout(new GridLayout(0,1));
        JPanel paymentFields = new JPanel(new FlowLayout());

        JPanel cardPanel = new JPanel(new FlowLayout());
        cardPanel.add(getCardLabel());
        cardPanel.add(getCardNumber());
        paymentPanel.add(cardPanel);

        JPanel expiryPanel = new JPanel(new FlowLayout());
        expiryPanel.add(getExpiryLabel());
        expiryPanel.add(getExpiryDate());
        paymentPanel.add(expiryPanel);

        JPanel csvPanel = new JPanel(new FlowLayout());
        csvPanel.add(getCsvLabel());
        csvPanel.add(getCsv());
        paymentPanel.add(csvPanel);

        JPanel buttons = new JPanel(new FlowLayout());
        buttons.add(cancelBut);
        buttons.add(confirmBut);

        //paymentPanel.add(paymentFields);

        frame.add("South", buttons);

        frame.add("Center", paymentPanel);

        frame.setVisible(true);
        frame.revalidate();
        frame.repaint();

        controlButtons();
    }

	/**
	 * This method controls the buttons on the Frame.
	 */
    private void controlButtons() {
        // TODO Auto-generated method stub

        getCancelBut().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                frame.dispose();

            }});

        getConfirmBut().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stug
                //add
                if(getCardNumber().getText().isEmpty() || Pattern.matches("[a-zA-Z]+", getCardNumber().getText())
                        || getCardNumber().getText().length() != 16)
                    JOptionPane.showMessageDialog(new JFrame(), "Please enter a valid card number!");
                else if(getExpiryDate().getText().isEmpty())
                    JOptionPane.showMessageDialog(new JFrame(), "Please enter a Expiry Date!");
                else if(getCsv().getText().isEmpty() || Pattern.matches("[a-zA-Z]+", getCsv().getText())
                        || getCsv().getText().length() != 3)
                    JOptionPane.showMessageDialog(new JFrame(), "Please enter a CSV number!");
                else
                    update();
            }});
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JButton getConfirmBut() {
        return confirmBut;
    }

    public void setConfirmBut(JButton confirmBut) {
        this.confirmBut = confirmBut;
    }

    public JButton getCancelBut() {
        return cancelBut;
    }

    public void setCancelBut(JButton cancelBut) {
        this.cancelBut = cancelBut;
    }

    public JLabel getCardLabel() {
        return cardLabel;
    }

    public void setCardLabel(JLabel cardLabel) {
        this.cardLabel = cardLabel;
    }

    public JLabel getExpiryLabel() {
        return expiryLabel;
    }

    public void setExpiryLabel(JLabel expiryLabel) {
        this.expiryLabel = expiryLabel;
    }

    public JLabel getCsvLabel() {
        return csvLabel;
    }

    public void setCsvLabel(JLabel csvLabel) {
        this.csvLabel = csvLabel;
    }

    public JTextField getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(JTextField cardNumber) {
        this.cardNumber = cardNumber;
    }

    public JTextField getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(JTextField expiryDate) {
        this.expiryDate = expiryDate;
    }

    public JTextField getCsv() {
        return csv;
    }

    public void setCsv(JTextField csv) {
        this.csv = csv;
    }
}
