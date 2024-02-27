package MidtermExam1stMakeupSalkan;

import java.util.HashMap;

interface Breathable {
    String breath();
}

interface Payment {
    void makePayment(String date, double amount);
}

class Human implements Breathable, Payment {
    private String fullName;
    private HashMap<String, Double> payments;

    public Human(String fullName, HashMap<String, Double> payments) {
        this.fullName = fullName;
        this.payments = payments;
    }

    @Override
    public String breath() {
        return "Breathing";
    }

    @Override
    public void makePayment(String date, double amount) {
        if(payments.containsKey(date)) {
            payments.put(date, payments.get(date) + amount);
        } else {
            payments.put(date, amount);
        }
    }

    public double getPayment(String date) {
        if (payments.containsKey(date)) {
            return payments.get(date);
        }
        return 0;
    }
}

class Main3 {
    public static void main(String[] args) {
        HashMap<String, Double> paymentsOfAjdin = new HashMap<>();
        Human human = new Human("Ajdin Karavdic", paymentsOfAjdin);
        System.out.println(human.breath());
        human.makePayment("7.2.", 150);
        human.makePayment("8.2.", 100);
        human.makePayment("8.2.", 150);
        human.makePayment("9.2.", 10);

        System.out.println(human.getPayment("7.2."));
        System.out.println(human.getPayment("8.2."));
        System.out.println(human.getPayment("9.2."));
    }
}
