package MidtermExamPrviPopravniSaIman;

import java.util.ArrayList;
import java.util.List;

interface Product {
    String displayDetails();
}

abstract class InventoryItem implements Product {
    private String productItems;
    private double price;
    private int quantity;

    public InventoryItem(String productItems, double price, int quantity) {
        this.productItems = productItems;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductItems() {
        return productItems;
    }

    public void setProductItems(String productItems) {
        this.productItems = productItems;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class ElectronicsProduct extends InventoryItem {
    private String brand;

    public ElectronicsProduct(String productItems, double price, int quantity, String brand) {
        super(productItems, price, quantity);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String displayDetails() {
        return "ElectronicsProduct";
    }
}

class ClothingProduct extends InventoryItem {
    private String size;

    public ClothingProduct(String productItems, double price, int quantity, String size) {
        super(productItems, price, quantity);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }


    @Override
    public String displayDetails() {
        return "ClothingProduct";
    }
}

class InventoryManager {
    public List<InventoryItem> updateInventory(List<InventoryItem> items) {
        List<InventoryItem> updated = new ArrayList<>();
        for (InventoryItem item : items) {
            if (item instanceof ElectronicsProduct) {
                ElectronicsProduct product = (ElectronicsProduct) item;
                product.setPrice(product.getPrice() * 0.9);
                updated.add(product);
            } else if (item instanceof ClothingProduct) {
                ClothingProduct product = (ClothingProduct) item;
                product.setPrice(product.getPrice() * 0.8);
                updated.add(product);
            }
        }
        return updated;
    }
}
