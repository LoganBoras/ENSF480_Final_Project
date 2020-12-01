package TRA.Domain;

public class RegisteredUser extends User {
    private Account userAccount;

    public RegisteredUser() {
        userAccount = new Account();
    }

    public RegisteredUser(int accountID, String cardNumber, String expiryDate, int csv, String emailAddress, String firstName, String lastName, String password) {
        userAccount = new Account(accountID, new Card(cardNumber, expiryDate, csv), emailAddress, firstName, lastName, password);
    }

    public void register(int accountID, String cardNumber, String expiryDate, int csv, String emailAddress, String firstName, String lastName, String password) {
        userAccount = new Account(accountID, new Card(cardNumber, expiryDate, csv), emailAddress, firstName, lastName, password);
    }

    public Account getUserAccount() {
        return userAccount;
    }
}
