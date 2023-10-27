package Week4.Lecture.CreditCard;

import java.util.Date;

public class CreditCard {
    private int cardNumber;
    private Date issueDate;
    private double balance;
    private String cvc;
    private CardType cardType;
    private CardIssuer cardIssuer;


    public CreditCard(int cardNumber, Date issueDate, double balance, String cvc, CardType cardType, CardIssuer cardIssuer) {
        this.cardNumber = cardNumber;
        this.issueDate = issueDate;
        this.balance = balance;
        this.cvc = cvc;
        this.cardType = cardType;
        this.cardIssuer = cardIssuer;
    }

    public CreditCard(double balance) {
        this.cardNumber = 123456789;
        this.issueDate = new Date();
        this.balance = balance;
        this.cvc = "123";
        this.cardType = CardType.CREDIT;
        this.cardIssuer = CardIssuer.MASTERCARD;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public CardType getCartType() {
        return cardType;
    }

    public void setCartType(CardType cardType) {
        this.cardType = cardType;
    }

    public CardIssuer getCardIssuer() {
        return cardIssuer;
    }

    public void setCardIssuer(CardIssuer cardIssuer) {
        this.cardIssuer = cardIssuer;
    }

    public void addDeposit (double dep){
        if (dep<2){
            System.out.println("broke man keep ya dolla.");
        }
        else {
            this.balance+=dep;
        }
    }

    public void withdrawal (double w){
        if(w>this.balance){
            System.out.println("nemas brate");
        }
        else {
            this.balance-=w;
        }
    }
}
