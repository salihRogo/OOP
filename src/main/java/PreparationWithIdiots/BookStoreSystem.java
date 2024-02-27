package PreparationWithIdiots;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BookStoreSystem {
    private List<Item> items;

    public BookStoreSystem(String filename) {
        items = readFromFile(filename);
    }

    public List<Item> getItems() {
        return items;
    }

    public static List<Item> readFromFile(String filename) {
        List<Item> itemList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            List<String> lines = reader.lines().toList();
            for (int i = 1; i < lines.size(); i++) {
                String[] splited = lines.get(i).split(";");
                if (splited[0].equals("") || splited[1].equals("") || splited[4].equals("")) {
                    throw new InvalidCastExceptions("Essential field(s) empty!");
                }
                itemList.add(
                        new Item.ItemBuilder()
                                .setDate(new SimpleDateFormat("MM/dd/yyyy").parse(splited[0]))
                                .setQuarter(splited[1])
                                .setQuantity(Integer.parseInt(splited[2]))
                                .setYear(Integer.parseInt(splited[3]))
                                .setCustomerID(splited[4])
                                .setTotalAmount(Double.parseDouble(splited[5]))
                                .setProfitPct(Integer.parseInt(splited[6]))
                                .setProfitInr(Double.parseDouble(splited[7]))
                                .setCostPrice(Double.parseDouble(splited[8]))
                                .build()
                );
            }
            reader.close();
            return itemList;
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
