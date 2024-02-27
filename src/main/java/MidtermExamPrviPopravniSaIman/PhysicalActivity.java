package MidtermExamPrviPopravniSaIman;

import java.util.HashMap;
import java.util.Optional;

interface PhysicalActivity {
    String exercise();
}

interface FinancialActivity {
    void manageExpenses(String date, double amount);
}

class Individual implements PhysicalActivity, FinancialActivity {
    private String name;
    private HashMap<String, Double> expenses;

    public Individual(String name) {
        this.name = name;
        expenses = new HashMap<>();
    }

    @Override
    public String exercise() {
        return "Exercising";
    }

    @Override
    public void manageExpenses(String date, double amount) {
        if (expenses.containsKey(date)) {
            expenses.put(date, expenses.get(date) + amount);
        } else {
            expenses.put(date, amount);
        }
    }

    public Optional<Double> getTotalExpenses(String date) {
        if (expenses.containsKey(date)) {
            return Optional.of(expenses.get(date));
        }
        return Optional.empty();
    }
}
