package FinalExamPreparationWithAjda.PripremaSaLecturea;

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
    private Double totalAmount;
    private Double profitPct;
    private Double profitInr;
    private Double costPrice;

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

    public Double getTotalAmount() {
        return totalAmount;
    }

    public Double getProfitPct() {
        return profitPct;
    }

    public Double getProfitInr() {
        return profitInr;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    static class ItemBuilder {
        private Date date;
        private String quarter;
        private int quantity;
        private int year;
        private String customerID;
        private Double totalAmount;
        private Double profitPct;
        private Double profitInr;
        private Double costPrice;

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

        public ItemBuilder setTotalAmount(Double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public ItemBuilder setProfitPct(Double profitPct) {
            this.profitPct = profitPct;
            return this;
        }

        public ItemBuilder setProfitInr(Double profitInr) {
            this.profitInr = profitInr;
            return this;
        }

        public ItemBuilder setCostPrice(Double costPrice) {
            this.costPrice = costPrice;
            return this;
        }

        public Item build() {
            return new Item(this);
        }
    }
}
