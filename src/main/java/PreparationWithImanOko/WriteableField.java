package PreparationWithImanOko;

import java.io.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface WriteableField {}

class InvalidCastException extends RuntimeException {
    public InvalidCastException(String message) {
        super(message);
    }
}

class Item {
    @WriteableField
    private Date date;
    private String quarter;
    private int quantity;
    private int year;
    @WriteableField
    private String customerId;
    @WriteableField
    private double totalAmount;
    private int profitPct;
    private double profitInr;
    private double costPrice;

    public Item(ItemBuilder builder) {
        this.date = builder.date;
        this.quarter = builder.quarter;
        this.quantity = builder.quantity;
        this.year = builder.year;
        this.customerId = builder.customerId;
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

    public String getCustomerId() {
        return customerId;
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
        private String customerId;
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

        public ItemBuilder setCustomerId(String customerId) {
            this.customerId = customerId;
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

class Read {
    private List<Item> items;

    public Read(String filename) {
        items = readFile(filename);
    }

    public List<Item> getItems() {
        return items;
    }

    public static List<Item> readFile(String filename) {
        List<Item> returnThisListOfItems = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            List<String> lines = reader.lines().toList();
            for (int i = 1; i < lines.size(); i++) {
                String[] separated = lines.get(i).split(";");
                if (separated[0].equals("") || separated[1].equals("") || separated[4].equals("")) {
                    throw new InvalidCastException("Essential field is empty! Fix that idiot");
                }
                Item item = new Item.ItemBuilder()
                        .setDate(new SimpleDateFormat("MM/dd/yyyy").parse(separated[0]))
                        .setQuarter(separated[1])
                        .setQuantity(Integer.parseInt(separated[2]))
                        .setYear(Integer.parseInt(separated[3]))
                        .setCustomerId(separated[4])
                        .setTotalAmount(Double.parseDouble(separated[5]))
                        .setProfitPct(Integer.parseInt(separated[6]))
                        .setProfitInr(Double.parseDouble(separated[7]))
                        .setCostPrice(Double.parseDouble(separated[8]))
                        .build();
                returnThisListOfItems.add(item);
            }
            reader.close();
            return returnThisListOfItems;
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class Write {
    public static void generateReport(String outputFilename, List<Item> items) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilename));
            Class<?> itemClass = Item.class;
            Field[] fieldsOfItemClass = itemClass.getDeclaredFields();
            for (Item item : items) {
                String writeThisStringToFileActuallyToBuffer = "";
                for (Field field : fieldsOfItemClass) {
                    if (field.isAnnotationPresent(WriteableField.class)) {
                        field.setAccessible(true);
                        writeThisStringToFileActuallyToBuffer = writeThisStringToFileActuallyToBuffer.concat(field.get(item).toString().concat(","));
                    }
                }
                writer.write(writeThisStringToFileActuallyToBuffer.substring(0, writeThisStringToFileActuallyToBuffer.length()-1).concat("\n"));
            }
            writer.close();
        } catch (IOException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

class StartMeBitch {
    public static void main(String[] args) {
        Read readThis = new Read("files/books.csv");
        Write.generateReport("files/books-report.csv", readThis.getItems());
    }
}
