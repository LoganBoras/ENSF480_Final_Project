package TRA.Domain;

public class Account {
    private int accountID;
    private Card card;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String password;

    public Account() {

    }

    public Account(int accountID, Card card, String emailAddress, String firstName, String lastName, String password) {
        this.accountID = accountID;
        this.card = card;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int id) {
        accountID = id;
    }

    public Card getCard() {
        return card;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }
}
