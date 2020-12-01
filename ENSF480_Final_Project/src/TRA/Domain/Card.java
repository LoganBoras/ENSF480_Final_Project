package TRA.Domain;

public class Card {
    private String cardNumber;
    private String expiryDate;
    private int csv;

    public Card(String cardNumber, String expiryDate, int csv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.csv = csv;
    }

    public void updateCardInformation(String cardNumber, String expiryDate, int csv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.csv = csv;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
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
