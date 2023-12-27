package Week6.Lab.HashMapsPromissoryNote;

import java.util.HashMap;

class PromissoryNote {
    private String name;
    private double value;

    HashMap<String, Double> debts;

    public PromissoryNote() {
        this.debts = new HashMap<>();
    }

    public void setLoan(String name, double value) {
        this.name = name;
        this.value = value;
        this.debts.put(this.name, this.value);
    }

    public double howMuchIsTheDebt(String whose) {
        // Impossible to get 0 since return type of this method() is double.
        // I tried casting, still doesn't work.

        if (!this.debts.containsKey(whose)) {
            return 0;
        } else {
            return this.debts.get(whose);
        }
    }
}

class Main {
    public static void main(String[] args) {
        PromissoryNote mattisNote = new PromissoryNote();
        mattisNote.setLoan("Arto", 51.5);
        mattisNote.setLoan("Mikael", 30);


        System.out.println(mattisNote.howMuchIsTheDebt("Arto"));
        System.out.println(mattisNote.howMuchIsTheDebt("Joel"));
    }
}
