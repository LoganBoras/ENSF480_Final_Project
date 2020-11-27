package TRA.Domain;

public class Card {
    private int cardNumber;
    private String expiryDate;
    private int csv;

    public Card(int cardNumber, String expiryDate, int csv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.csv = csv;
    }

    public void updateCardInformation(int cardNumber, String expiryDate, int csv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.csv = csv;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getCsv() {
        return csv;
    }

    public void setCsv(int csv) {
        this.csv = csv;
    }
}
