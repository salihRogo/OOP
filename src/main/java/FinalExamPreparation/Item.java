package FinalExamPreparation;

import java.util.Date;

public class Item {
    @WritableField
    private Date date;
    private String quarter;
    private int quantity;
    private int year;
    @WritableField
    private String customerID;
    @WritableField
    private double totalAmount;
    private double profitPercentage;
    private double profitInr;
    private double costPrice;

    public Item(ItemBuilder itemBuilder) {
        this.date = itemBuilder.date;
        this.quarter = itemBuilder.quarter;
        this.quantity = itemBuilder.quantity;
        this.year = itemBuilder.year;
        this.customerID = itemBuilder.customerID;
        this.totalAmount = itemBuilder.totalAmount;
        this.profitPercentage = itemBuilder.profitPercentage;
        this.profitInr = itemBuilder.profitInr;
        this.costPrice = itemBuilder.costPrice;
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

    public double getProfitPercentage() {
        return profitPercentage;
    }

    public double getProfitInr() {
        return profitInr;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public static class ItemBuilder {
        private Date date;
        private String quarter;
        private int quantity;
        private int year;
        private String customerID;
        private double totalAmount;
        private double profitPercentage;
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

        public ItemBuilder setProfitPercentage(double profitPercentage) {
            this.profitPercentage = profitPercentage;
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
