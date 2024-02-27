package FinalExamPreparation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    private List<Item> items;

    public ReadFile(String filepath) {
        items = readFile(filepath);
    }

    private static List<Item> readFile(String filepath) {
        try {
            List<Item> readItems = new ArrayList<>();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
            List<String> lines = bufferedReader.lines().toList();

            for (int i = 1; i < lines.size(); i++) {
                String[] splited = lines.get(i).split(";");
                if (splited[0].equals("") || splited[1].equals("") || splited[4].equals("")) {
                    throw new InvalidCastException("The values must not be empty");
                }
                readItems.add(
                        new Item.ItemBuilder()
                                .setDate(new SimpleDateFormat("MM/dd/yyyy").parse(splited[0]))
                                .setQuarter(splited[1])
                                .setQuantity(Integer.parseInt(splited[2]))
                                .setYear(Integer.parseInt(splited[3]))
                                .setCustomerID(splited[4])
                                .setTotalAmount(Double.parseDouble(splited[5]))
                                .setProfitPercentage(Double.parseDouble(splited[6]))
                                .setProfitInr(Double.parseDouble(splited[7]))
                                .setCostPrice(Double.parseDouble(splited[8]))
                                .build()
                );
            }
            return readItems;
        } catch (IOException | ParseException e) {
            throw new InvalidCastException("Problem with file reading");
        }
    }
}
