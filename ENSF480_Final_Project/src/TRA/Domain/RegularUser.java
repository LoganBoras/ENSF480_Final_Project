package TRA.Domain;

public class RegularUser extends User {
    private String email;
    private Card card;

    public RegularUser() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(String cardNumber, String expiry, int csv) {
        this.card = new Card(cardNumber, expiry, csv);
    }
}
