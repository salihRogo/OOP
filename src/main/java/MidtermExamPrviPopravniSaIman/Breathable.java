package MidtermExamPrviPopravniSaIman;

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
        if (payments.containsKey(date)) {
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
