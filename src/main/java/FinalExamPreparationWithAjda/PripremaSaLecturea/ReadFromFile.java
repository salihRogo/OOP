package FinalExamPreparationWithAjda.PripremaSaLecturea;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {
    private List<Item> items;

    public ReadFromFile(String filename) {
        items = readFile(filename);
    }

    public List<Item> getItems() {
        return items;
    }

    public static List<Item> readFile(String filename) {
        List<Item> returnThisList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            List<String> lines = reader.lines().toList();
            for (int i = 1; i < lines.size(); i++) {
                String[] splitedLine = lines.get(i).split(";");
                if (splitedLine[0].equals("") && splitedLine[1].equals("") && splitedLine[4].equals("")) {
                    throw new InvalidCastException("One or more of the following fields is missing: [date, quarter, customerID]");
                }
                returnThisList.add(
                        new Item.ItemBuilder()
                                .setDate(new SimpleDateFormat("MM/dd/yyyy").parse(splitedLine[0]))
                                .setQuarter(splitedLine[1])
                                .setQuantity(Integer.parseInt(splitedLine[2]))
                                .setYear(Integer.parseInt(splitedLine[3]))
                                .setCustomerID(splitedLine[4])
                                .setTotalAmount(Double.parseDouble(splitedLine[5]))
                                .setProfitPct(Double.parseDouble(splitedLine[6]))
                                .setProfitInr(Double.parseDouble(splitedLine[7]))
                                .setCostPrice(Double.parseDouble(splitedLine[8]))
                                .build()
                );
            }
            reader.close();
            return returnThisList;
        } catch (FileNotFoundException e) {
            throw new InvalidCastException("File you are searching for is not found at given location.");
        } catch (ParseException e) {
            throw new InvalidCastException("Problem with parsing!");
        } catch (IOException e) {
            throw new InvalidCastException("IO problems!");
        }
    }
}
