package PreparationWithIdiots;

import java.util.Date;

public class Item {
    @WritableFields
    private Date date;
    private String quarter;
    private int quantity;
    private int year;
    @WritableFields
    private String customerID;
    @WritableFields
    private double totalAmount;
    private int profitPct;
    private double profitInr;
    private double costPrice;

    public Item(ItemBuilder builder) {
        this.date = builder.date;
        this.quarter = builder.quarter;
        this.quantity = builder.quantity;
        this.year = builder.year;
        this.customerID = builder.customerID;
        this.totalAmount = builder.totalAmount;
        this.profitPct = builder.profitPct;
        this.profitInr = builder.profitInr;
        this.costPrice = builder.costPrice;
    }

    public Date getDate() {
        return date;
    }

    public String getQuarter() {
        return quarter;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getYear() {
        return year;
    }

    public String getCustomerID() {
        return customerID;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public int getProfitPct() {
        return profitPct;
    }

    public double getProfitInr() {
        return profitInr;
    }

    public double getCostPrice() {
        return costPrice;
    }

    static class ItemBuilder {
        private Date date;
        private String quarter;
        private int quantity;
        private int year;
        private String customerID;
        private double totalAmount;
        private int profitPct;
        private double profitInr;
        private double costPrice;

        public ItemBuilder setDate(Date date) {
            this.date = date;
            return this;
        }

        public ItemBuilder setQuarter(String quarter) {
            this.quarter = quarter;
            return this;
        }

        public ItemBuilder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public ItemBuilder setYear(int year) {
            this.year = year;
            return this;
        }

        public ItemBuilder setCustomerID(String customerID) {
            this.customerID = customerID;
            return this;
        }

        public ItemBuilder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public ItemBuilder setProfitPct(int profitPct) {
            this.profitPct = profitPct;
            return this;
        }

        public ItemBuilder setProfitInr(double profitInr) {
            this.profitInr = profitInr;
            return this;
        }

        public ItemBuilder setCostPrice(double costPrice) {
            this.costPrice = costPrice;
            return this;
        }

        public Item build() {
            return new Item(this);
        }
    }
}
