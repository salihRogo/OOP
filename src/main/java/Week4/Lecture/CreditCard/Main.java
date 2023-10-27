package Week4.Lecture.CreditCard;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        CreditCard avdosCard = new CreditCard(133444.4455);
        CreditCard amkesCard = new CreditCard(1334444455, new Date(12,12,2022), 21, "123", CardType.DEBIT, CardIssuer.VISA);

        amkesCard.withdrawal(20);
        amkesCard.addDeposit(1222222);
        System.out.println(amkesCard.getBalance());
    }
}
