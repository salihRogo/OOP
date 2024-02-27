package FinalExamPreparation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class GenerateReport {
    public static void writeReport(String outputFilePath, List<Item> itemList) throws NullPointerException {
        Field[] fields = Item.class.getDeclaredFields();

        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFilePath));

        String x = null;
        System.out.println(x.length());
    }
    public static void vblalla() throws Exception {
        try {
            writeReport("lala", null);
        } catch (NullPointerException e) {
            throw new Exception("Problem.");
        }
    }
}

